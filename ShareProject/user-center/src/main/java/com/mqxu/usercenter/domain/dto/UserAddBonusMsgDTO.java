package com.mqxu.usercenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserAddBonusMsgDTO
 * @Description 用户增加积分消息数据传输对象
 * @Author mqxu
 * @Date 2020/10/6
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("用户添加积分的消息对象")
public class UserAddBonusMsgDTO {
    /**
     * 为谁加积分
     */
    @ApiModelProperty(name = "userId", value = "用户id")
    private Integer userId;
    /**
     * 加多少积分
     */
    @ApiModelProperty(name = "bonus", value = "积分数")
    private Integer bonus;

    /**
     * 描述
     */
    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    /**
     * 事件
     */
    @ApiModelProperty(name = "event", value = "积分事件")
    private String event;
}
