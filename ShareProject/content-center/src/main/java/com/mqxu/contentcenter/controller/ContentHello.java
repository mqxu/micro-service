package com.mqxu.contentcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author mqxu
 * @date 2020.09.22
 */
//@RestController
//@RequestMapping(value = "/content")
public class ContentHello {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/call")
    @ApiIgnore
    public String getHello(){
        return restTemplate.getForObject("http://localhost:8082/user/hello",String.class);
    }
}
