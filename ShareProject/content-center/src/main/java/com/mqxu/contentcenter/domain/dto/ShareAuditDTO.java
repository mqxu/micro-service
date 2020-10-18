package com.mqxu.contentcenter.domain.dto;

import com.mqxu.contentcenter.domain.enums.AuditStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mqxu
 * 分享审核数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShareAuditDTO {
    /**
     * 审核状态
     */
    private AuditStatusEnum auditStatusEnum;
    /**
     * 原因
     */
    private String reason;

    /**
     * 是否发布显示
     */
    private Boolean showFlag;
}
