package com.soft1851.cloud.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: mq_xu
 * @created: 2020/09/12 22:40
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping
    public String getHello(){
        return "hello spring cloud";
    }
}
