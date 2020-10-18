package com.mqxu.usercenter.domain.dto;

import com.mqxu.usercenter.domain.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户登录成功得到的响应对象")
public class LoginRespDTO {
   /**
    * 用户信息
    */
   @ApiModelProperty(name = "user", value = "用户对象")
   private UserRespDTO user;
   /**
    * token数据
    */
   @ApiModelProperty(name = "token", value = "token对象")
   private JwtTokenRespDTO token;
}
