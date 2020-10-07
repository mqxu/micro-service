package com.mqxu.contentcenter.service.impl;

import com.mqxu.contentcenter.dao.NoticeMapper;
import com.mqxu.contentcenter.domain.entity.Notice;
import com.mqxu.contentcenter.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


/**
 * @ClassName NoticeServiceImpl
 * @Description TODO
 * @Author mqxu
 * @Date 2020/10/4
 **/
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;

    @Override
    public Notice getLatest() {
        Example example = new Example(Notice.class);
        //按id降序
        example.setOrderByClause("id DESC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("showFlag",1);
        return noticeMapper.selectByExample(example).get(0);
    }
}
