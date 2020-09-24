package com.soft1851.cloud.study.handler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description: 注入 RestTemplate 实例，业务方法中通过 RestTemplate 来调用 provider 的相关服务
 * @author: mq_xu
 * @created: 2020/09/13 08:10
 */
@RequestMapping("/consumer")
@RestController
public class HelloHandler {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String getHello(){
        //通过restTemplate来调用provider提供的服务
        return restTemplate.getForObject("http://mqxu.com:8001/hello",String.class);
    }
}
