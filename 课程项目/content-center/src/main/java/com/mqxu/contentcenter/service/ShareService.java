package com.mqxu.contentcenter.service;

import com.mqxu.contentcenter.domain.dto.ShareDTO;

import java.util.List;

/**
 * @author mqxu
 */
public interface ShareService {
    /**
     * 获得分享详情
     * @return  ShareDTO
     */
    ShareDTO findById(Integer id);

    String getHello();
}
