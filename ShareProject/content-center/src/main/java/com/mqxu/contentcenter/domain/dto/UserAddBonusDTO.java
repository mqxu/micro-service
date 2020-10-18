package com.mqxu.contentcenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserAddBonusDTO
 * @Description 用户增加积分的数据传输对象
 * @Author mqxu
 * @Date 2020/10/6
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户添加积分数据传输对象")
public class UserAddBonusDTO {
    @ApiModelProperty(name = "userId", value = "用户id")
    private Integer userId;

    @ApiModelProperty(name = "bonus", value = "积分数")
    private Integer bonus;
}
