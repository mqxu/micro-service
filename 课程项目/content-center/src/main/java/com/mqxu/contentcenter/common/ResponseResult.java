package com.mqxu.contentcenter.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mqxu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("请求返回对象")
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = -3948389268046368059L;

    @ApiModelProperty("code")
    private Integer code;

    @ApiModelProperty("msg")
    private String msg;

    @ApiModelProperty("data")
    private Object data;

}