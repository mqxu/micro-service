package com.mqxu.contentcenter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mqxu.contentcenter.dao.MidUserShareMapper;
import com.mqxu.contentcenter.dao.ShareMapper;
import com.mqxu.contentcenter.domain.dto.*;
import com.mqxu.contentcenter.domain.entity.MidUserShare;
import com.mqxu.contentcenter.domain.entity.Share;
import com.mqxu.contentcenter.domain.enums.AuditStatusEnum;
import com.mqxu.contentcenter.feignclient.UserCenterFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mqxu
 */

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    private final ShareMapper shareMapper;
    private final MidUserShareMapper midUserShareMapper;
    private final UserCenterFeignClient userCenterFeignClient;
    private final RocketMQTemplate rocketMQTemplate;

    /**
     * 根据id查找分享详情
     *
     * @param id
     * @return ShareDTO
     */
    public ShareDTO findById(Integer id) {
        // 获取分享实体
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 获得发布人id
        Integer userId = share.getUserId();
        //通过feign请求用户中心接口，获得发布人详情
        ResponseDTO responseDTO = this.userCenterFeignClient.findUserById(userId);
        UserDTO userDTO = convert(responseDTO);
        return ShareDTO.builder()
                .share(share)
                .wxNickname(userDTO.getWxNickname())
                .build();
    }


    /**
     * 分页查询某个用户首页可见的资源列表
     *
     * @param title
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return pageInfo
     */
    public PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId) {
        //启动分页
        PageHelper.startPage(pageNo, pageSize);
        //构造查询实例
        Example example = new Example(Share.class);
        example.setOrderByClause("id DESC");
        Example.Criteria criteria = example.createCriteria();
        //如标题关键字不空，则加上模糊查询条件，否则结果即所有数据
        if (StringUtil.isNotEmpty(title)) {
            criteria.andLike("title", "%" + title + "%");
        }
        criteria.andEqualTo("showFlag", true)
                .andEqualTo("auditStatus", "PASS");

        //执行按条件查询
        List<Share> shares = this.shareMapper.selectByExample(example);
        //处理后的Share数据列表
        List<Share> sharesDeal;
        // 1. 如果用户未登录，那么downloadUrl全部设为null
        if (userId == null) {
            sharesDeal = shares.stream()
                    .peek(share -> share.setDownloadUrl(null))
                    .collect(Collectors.toList());
        }
        // 2. 如果用户登录了，那么查询一下mid_user_share，如果没有数据，那么这条share的downloadUrl也设为null
        //只有自己分享的资源才能直接看到下载链接，否则显示"兑换"
        else {
            sharesDeal = shares.stream()
                    .peek(share -> {
                        MidUserShare midUserShare = this.midUserShareMapper.selectOne(
                                MidUserShare.builder()
                                        .userId(userId)
                                        .shareId(share.getId())
                                        .build()
                        );
                        if (midUserShare == null) {
                            share.setDownloadUrl(null);
                        }
                    })
                    .collect(Collectors.toList());
        }
        return new PageInfo<>(sharesDeal);
    }

    /**
     * 查询待审核状态的shares列表
     *
     * @return List<Share>
     */
    public List<Share> querySharesNotYet() {
        Example example = new Example(Share.class);
        example.setOrderByClause("id DESC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("showFlag", false)
                .andEqualTo("auditStatus", "NOT_YET");
        return this.shareMapper.selectByExample(example);
    }

    /**
     * 投稿
     *
     * @param shareRequestDTO
     * @return int
     */
    public int contribute(ShareRequestDTO shareRequestDTO) {
        Share share = Share.builder()
                .isOriginal(shareRequestDTO.getIsOriginal())
                .author(shareRequestDTO.getAuthor())
                .price(shareRequestDTO.getPrice())
                .downloadUrl(shareRequestDTO.getDownloadUrl())
                .summary(shareRequestDTO.getSummary())
                .buyCount(0)
                .title(shareRequestDTO.getTitle())
                .userId(shareRequestDTO.getUserId())
                .cover(shareRequestDTO.getCover())
                .createTime(new Date())
                .updateTime(new Date())
                .showFlag(false)
                .auditStatus("NOT_YET")
                .reason("未审核")
                .build();
        return shareMapper.insert(share);
    }

    /**
     * 审核
     *
     * @param id
     * @param shareAuditDTO
     * @return share
     */
    public Share auditById(Integer id, ShareAuditDTO shareAuditDTO) {
        // 1. 查询share是否存在，不存在或者当前的audit_status != NOT_YET，那么抛异常
        Share share = this.shareMapper.selectByPrimaryKey(id);
        if (share == null) {
            throw new IllegalArgumentException("参数非法！该分享不存在！");
        }
        if (!Objects.equals("NOT_YET", share.getAuditStatus())) {
            throw new IllegalArgumentException("参数非法！该分享已审核通过或审核不通过！");
        }
        //2.审核资源，将状态改为PASS或REJECT，更新原因和是否发布显示
        share.setAuditStatus(shareAuditDTO.getAuditStatusEnum().toString());
        share.setReason(shareAuditDTO.getReason());
        share.setShowFlag(shareAuditDTO.getShowFlag());
        this.shareMapper.updateByPrimaryKey(share);

        //3. 向mid_user插入一条数据，分享的作者通过审核后，默认拥有了下载权限
        this.midUserShareMapper.insert(
                MidUserShare.builder()
                        .userId(share.getUserId())
                        .shareId(id)
                        .build()
        );

        // 4. 如果是PASS，那么发送消息给rocketmq，让用户中心去消费，并为发布人添加积分
        if (AuditStatusEnum.PASS.equals(shareAuditDTO.getAuditStatusEnum())) {
            this.rocketMQTemplate.convertAndSend(
                    "add-bonus",
                    UserAddBonusMsgDTO.builder()
                            .userId(share.getUserId())
                            .bonus(50)
                            .build());
        }


        return share;
    }

    /**
     * 兑换
     *
     * @param exchangeDTO
     * @return share
     */
    public Share exchange(ExchangeDTO exchangeDTO) {
        int userId = exchangeDTO.getUserId();
        int shareId = exchangeDTO.getShareId();
        // 1. 根据id查询share，校验是否存在
        Share share = this.shareMapper.selectByPrimaryKey(shareId);
        if (share == null) {
            throw new IllegalArgumentException("该分享不存在！");
        }
        Integer price = share.getPrice();

        // 2. 如果当前用户已经兑换过该分享，则直接返回
        MidUserShare midUserShare = this.midUserShareMapper.selectOne(
                MidUserShare.builder()
                        .shareId(shareId)
                        .userId(userId)
                        .build()
        );
        if (midUserShare != null) {
            return share;
        }

        // 3. 根据当前登录的用户id，查询积分是否够
        //这里一定要注意通过调用户中心接口得到的返回值，外面已经封装了一层了，要解析才能拿到真正的用户数据
        ResponseDTO responseDTO = this.userCenterFeignClient.findUserById(userId);
        UserDTO userDTO = convert(responseDTO);
        System.out.println(userDTO);
        if (price > userDTO.getBonus()) {
            throw new IllegalArgumentException("用户积分不够！");
        }

        // 4. 修改积分
        this.userCenterFeignClient.updateBonus(
                UserAddBonusDTO.builder()
                        .userId(userId)
                        .bonus(price * -1)
                        .build()
        );
        //5. 向mid_user_share表里插入一条数据
        this.midUserShareMapper.insert(
                MidUserShare.builder()
                        .userId(userId)
                        .shareId(shareId)
                        .build()
        );
        return share;
    }

    /**
     * 我的兑换
     *
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return sharesDeal
     */
    public PageInfo<Share> myExchange(Integer pageNo, Integer pageSize, Integer userId) {
        PageHelper.startPage(pageNo, pageSize);
        Example example = new Example(Share.class);
        example.setOrderByClause("id DESC");
        List<Share> shares = this.shareMapper.selectByExample(example);
        //处理后的Share数据列表
        List<Share> sharesDeal;
        //过滤出在中间表存在记录的数据
        sharesDeal = shares.stream()
                .filter(share -> this.midUserShareMapper.selectOne(
                        MidUserShare.builder()
                                .userId(userId)
                                .shareId(share.getId())
                                .build()) != null
                )
                .collect(Collectors.toList());
        return new PageInfo<>(sharesDeal);
    }


    /**
     * 我的投稿
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return shares
     */
    public PageInfo<Share> myContribute(Integer pageNo, Integer pageSize, Integer userId) {
        PageHelper.startPage(pageNo, pageSize);
        Example example = new Example(Share.class);
        example.setOrderByClause("id DESC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        List<Share> shares = this.shareMapper.selectByExample(example);
        return new PageInfo<>(shares);
    }

    /**
     * 将统一的返回响应结果转换为UserDTO类型
     *
     * @param responseDTO
     * @return userDTO
     */
    private UserDTO convert(ResponseDTO responseDTO) {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = null;
        try {
            String json = mapper.writeValueAsString(responseDTO.getData());
            userDTO = mapper.readValue(json, UserDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userDTO;
    }

}
