package com.mqxu.usercenter.domain.dto;

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
public class UserRespDTO {
    /**
     * id
     */
    private Integer id;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 积分
     */
    private Integer bonus;
    /**
     * 微信昵称
     */
    private String wxNickname;
}
