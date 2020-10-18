package com.mqxu.contentcenter.service;

import com.github.pagehelper.PageInfo;
import com.mqxu.contentcenter.domain.dto.ShareAuditDTO;
import com.mqxu.contentcenter.domain.dto.ShareDTO;
import com.mqxu.contentcenter.domain.dto.ShareRequestDTO;
import com.mqxu.contentcenter.domain.entity.Share;
import com.mqxu.contentcenter.domain.enums.AuditStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShareServiceTest {
    @Autowired
    private ShareService shareService;

    @Test
    void findById() {
    }

    @Test
    void query() {
        PageInfo<Share> query = shareService.query(null, 1, 10, 1);
        //List<Share> list = query.getList();
        //list.forEach(item-> System.out.println(item.getTitle()+","+item.getDownloadUrl()));
    }

    @Test
    void insert() {
        ShareRequestDTO shareRequestDTO = ShareRequestDTO.builder()
                .userId(24)
                .author("陶然然")
                .downloadUrl("www.baidu.com")
                .price(20)
                .summary("测试资源")
                .title("测试资源")
                .isOriginal(Boolean.TRUE)
                .cover("https://img2.sycdn.imooc.com/szimg/5b3082da0001d7e905400300-360-202.jpg")
                .build();
        shareService.contribute(shareRequestDTO);
    }

    @Test
    void auditById() {
        //Share share = shareService.auditById(11, ShareAuditDTO.builder().auditStatusEnum(AuditStatusEnum.PASS).reason("great").build());
        //System.out.println(share);
    }

    @Test
    void querySharesNotYet() {
        List<Share> list = shareService.querySharesNotYet();
        list.forEach(item -> System.out.println(item.getTitle() + "," + item.getDownloadUrl()));
    }

}