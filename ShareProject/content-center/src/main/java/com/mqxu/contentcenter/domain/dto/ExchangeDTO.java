package com.mqxu.contentcenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 兑换数据传输对象
 * @author: mq_xu
 * @create: 2020-10-14 08:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("兑换传输的数据对象")
public class ExchangeDTO {
    @ApiModelProperty(name = "userId",value = "兑换人id")
    private Integer userId;

    @ApiModelProperty(name = "shareId",value = "所兑换资源的id")
    private Integer shareId;
}
