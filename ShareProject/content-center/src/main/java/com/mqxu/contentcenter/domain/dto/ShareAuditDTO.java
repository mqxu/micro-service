package com.mqxu.contentcenter.domain.dto;

import com.mqxu.contentcenter.domain.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("审核分享的数据传输对象")
public class ShareAuditDTO {
    /**
     * 审核状态
     */
    @ApiModelProperty(name = "auditStatusEnum",value = "审核状态")
    private AuditStatusEnum auditStatusEnum;
    /**
     * 原因
     */
    @ApiModelProperty(name = "reason",value = "原因")
    private String reason;

    /**
     * 是否发布显示
     */
    @ApiModelProperty(name = "showFlag",value = "是否发布显示")
    private Boolean showFlag;
}
