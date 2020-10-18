package com.mqxu.usercenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 返回结果中的用户数据对象
 * @author: mq_xu
 * @create: 2020-10-12 20:14
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel("登录成功的用户数据返回对象")
public class UserRespDTO {
    /**
     * id
     */
    @ApiModelProperty(name = "id", value = "用户id")
    private Integer id;
    /**
     * 头像地址
     */
    @ApiModelProperty(name = "avatarUrl", value = "用户头像地址")
    private String avatarUrl;
    /**
     * 积分
     */
    @ApiModelProperty(name = "bonus", value = "用户积分")
    private Integer bonus;
    /**
     * 微信昵称
     */
    @ApiModelProperty(name = "wxNickname", value = "微信昵称")
    private String wxNickname;

    /**
     * 角色
     */
    @ApiModelProperty(name = "roles", value = "角色")
    private String roles;
}
