package com.mqxu.gateway;

import java.time.LocalTime;

/**
 * @description: 定义开始和结束的两个参数
 * @author: mq_xu
 * @create: 2020-10-09 10:55
 **/
public class TimeBetweenConfig {
  private LocalTime start;
  private LocalTime end;

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
