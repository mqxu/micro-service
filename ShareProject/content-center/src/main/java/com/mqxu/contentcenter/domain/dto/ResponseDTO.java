package com.mqxu.contentcenter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 统一返回结果封装对象
 * @author: mq_xu
 * @create: 2020-10-14 15:55
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO {
    private Boolean succ;
    private String code;
    private String msg;
    private Object data;
    private Long ts;
}
