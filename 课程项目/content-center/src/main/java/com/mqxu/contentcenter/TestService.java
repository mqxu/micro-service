package com.mqxu.contentcenter;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestService
 * @Description TestService
 * @Author mqxu
 * @Date 2020/10/6
 **/
@Slf4j
@Service
public class TestService {
   //指定sentinel的资源名称
    @SentinelResource(value = "common",blockHandler = "handleException")

    public String commonMethod() {
        log.info("commonMethod....");
        return "common";
    }
    public String handleException(){
        return "流量超限，服务不可用";
    }
}
