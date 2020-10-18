package com.mqxu.contentcenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mqxu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("用户数据传输对象")
public class UserDTO {
    /**
     * Id
     */
    @ApiModelProperty(name = "id", value = "用户id")
    private Integer id;

    /**
     * 微信id
     */
    @ApiModelProperty(name = "wxId", value = "微信id")
    private String wxId;

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

    /**
     * 头像地址
     */
    @ApiModelProperty(name = "avatarUrl", value = "头像地址")
    private String avatarUrl;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;

    /**
     * 积分
     */
    @ApiModelProperty(name = "bonus", value = "积分")
    private Integer bonus;
}
