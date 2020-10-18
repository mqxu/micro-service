package com.mqxu.usercenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户登录时的传输对象（客户端->后台）
 * @author: mq_xu
 * @create: 2020-10-11 16:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("用户登录时的传输对象")
public class LoginDTO {
    /**
     * openId
     */
    @ApiModelProperty(name = "openId", value = "微信平台openId")
    private String openId;
    /**
     * loginCode
     */
    @ApiModelProperty(name = "loginCode", value = "临时的code")
    private String loginCode;
    /**
     * 微信昵称
     */
    @ApiModelProperty(name = "wxNickname", value = "微信昵称")
    private String wxNickname;
    /**
     * 头像地址
     */
    @ApiModelProperty(name = "avatarUrl", value = "用户头像")
    private String avatarUrl;
}
