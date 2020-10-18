package com.mqxu.usercenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 返回结果中的Jwt数据对象
 * @author: mq_xu
 * @create: 2020-10-12 20:13
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel("登录成功的Jwt返回对象")
public class JwtTokenRespDTO {
    /**
     * token
     */
    @ApiModelProperty(name = "token", value = "token字符串")
    private String token;
    /**
     * 过期时间
     */
    @ApiModelProperty(name = "expirationTime", value = "过期时间")
    private Long expirationTime;
}

