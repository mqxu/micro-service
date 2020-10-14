package com.mqxu.contentcenter.service;

import com.github.pagehelper.PageInfo;
import com.mqxu.contentcenter.domain.dto.ExchangeDTO;
import com.mqxu.contentcenter.domain.dto.ShareAuditDTO;
import com.mqxu.contentcenter.domain.dto.ShareDTO;
import com.mqxu.contentcenter.domain.dto.ShareRequestDTO;
import com.mqxu.contentcenter.domain.entity.Share;

import javax.servlet.http.HttpServletRequest;


/**
 * @author mqxu
 */
public interface ShareService {
    /**
     * 分享详情
     *
     * @param id
     * @return ShareDTO
     */
    ShareDTO findById(Integer id);

    /**
     * 根据标题模糊查询某个用户的分享列表数据，title为空则为所有数据，查询结果分页
     *
     * @param title
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return PageInfo<Share>
     */
    PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId);


    /**
     * 投稿
     *
     * @param shareRequestDTO
     * @return Share
     */
    int contribute(ShareRequestDTO shareRequestDTO);

    /**
     * 审核投稿
     *
     * @param id
     * @param shareAuditDTO
     * @return Share
     */
    Share auditById(Integer id, ShareAuditDTO shareAuditDTO);

    /**
     * 积分兑换资源
     *
     * @param exchangeDTO
     * @return Share
     */
    Share exchange(ExchangeDTO exchangeDTO);
}
