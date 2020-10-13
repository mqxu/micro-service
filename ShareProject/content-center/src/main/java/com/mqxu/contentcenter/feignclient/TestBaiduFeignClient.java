package com.mqxu.contentcenter.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TestBaiduFeignClient
 * @Description 脱离Ribbon使用Feign
 * @Author mqxu
 * @Date 2020/9/30
 **/
//@FeignClient(name = "baidu", url = "http://www.baidu.com")
public interface TestBaiduFeignClient {
    /**
     * 请求百度首页
     * @return
     */
    @GetMapping("")
    String index();
}
