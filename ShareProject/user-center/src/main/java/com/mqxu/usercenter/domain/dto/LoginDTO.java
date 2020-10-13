package com.mqxu.usercenter.domain.dto;

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
public class LoginDTO {
    /**
     * openId
     */
    private String openId;
    /**
     * loginCode
     */
    private String loginCode;
    /**
     * 微信昵称
     */
    private String wxNickname;
    /**
     * 头像地址
     */
    private String avatarUrl;
}
