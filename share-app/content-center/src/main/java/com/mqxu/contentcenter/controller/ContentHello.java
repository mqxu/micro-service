package com.mqxu.contentcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mqxu
 * @date 2020.09.22
 */
@RestController
@RequestMapping(value = "/content")
public class ContentHello {
    @GetMapping
    public String getHello(){
        return "hello content-center!";
    }
}
