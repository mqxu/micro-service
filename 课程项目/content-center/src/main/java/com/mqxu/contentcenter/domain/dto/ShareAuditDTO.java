package com.mqxu.contentcenter.domain.dto;

import com.mqxu.contentcenter.domain.enums.AuditStatusEnum;
import lombok.Data;

/**
 * @author mqxu
 */
@Data
public class ShareAuditDTO {
    /**
     * 审核状态
     */
    private AuditStatusEnum auditStatusEnum;
    /**
     * 原因
     */
    private String reason;
}
