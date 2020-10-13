package com.mqxu.usercenter.domain.dto;

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
public class UserAddBonusMsgDTO {
    /**
     * 为谁加积分
     */
    private Integer userId;
    /**
     * 加多少积分
     */
    private Integer bonus;

    /**
     * 描述
     */
    private String description;

    /**
     * 事件
     */
    private String event;
}
