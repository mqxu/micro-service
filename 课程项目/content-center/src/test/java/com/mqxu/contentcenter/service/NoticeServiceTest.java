package com.mqxu.contentcenter.service;

import com.mqxu.contentcenter.domain.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeServiceTest {
    @Autowired
    private NoticeService noticeService;

    @Test
    void getLatest() {
        Notice latest = noticeService.getLatest();
        System.out.println(latest);
    }
}