package com.mqxu.usercenter.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * @ClassName BonusEventLog
 * @Description TODO
 * @Author mqxu
 * @Date 2020/10/7
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bonus_event_log")
public class BonusEventLog {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * user.id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 积分操作值
     */
    @Column(name = "value")
    private Integer value;

    /**
     * 发生的事件
     */
    @Column(name = "event")
    private String event;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;
}