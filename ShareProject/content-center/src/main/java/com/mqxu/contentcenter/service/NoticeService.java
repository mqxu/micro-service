package com.mqxu.contentcenter.service;

import com.mqxu.contentcenter.domain.entity.Notice;


/**
 * @author mqxu
 */
public interface NoticeService {
    /**
     * 查询最新公告
     * @return
     */
   Notice getLatest();
}
