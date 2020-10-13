package com.mqxu.usercenter.domain.dto;

import com.mqxu.usercenter.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 登录返回结果
 * @author: mq_xu
 * @create: 2020-10-11 16:43
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRespDTO {
   /**
    * 用户信息
    */
   private UserRespDTO user;
   /**
    * token数据
    */
   private JwtTokenRespDTO token;
}
