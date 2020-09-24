package com.mqxu.usercenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mqxu
 * @date 2020.09.22
 */
@RestController
@RequestMapping(value = "/user")
public class UserHello {

    @GetMapping(value = "/hello")
    public String getHello(){
        return "hello ,this message is from user-center!";
    }
}
