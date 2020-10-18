package com.mqxu.contentcenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 统一返回结果封装对象
 * @author: mq_xu
 * @create: 2020-10-14 15:55
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("统一封装的返回结果对象")
public class ResponseDTO {
    @ApiModelProperty(name = "succ",value = "是否成功")
    private Boolean succ;

    @ApiModelProperty(name = "code",value = "返回的状态吗")
    private String code;

    @ApiModelProperty(name = "msg",value = "返回消息")
    private String msg;

    @ApiModelProperty(name = "data",value = "返回数据")
    private Object data;

    @ApiModelProperty(name = "ts",value = "服务器时间戳")
    private Long ts;
}
