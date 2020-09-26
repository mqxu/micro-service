package com.mqxu.usercenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mqxu
 * @date 2020.09.22
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserHello {

    @GetMapping(value = "/hello")
    public String getHello(){
        log.info("我被调用了");
        return "hello ,this message is from user-center!";
    }
}
