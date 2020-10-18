package com.mqxu.usercenter.service;

import com.mqxu.usercenter.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;
    @Test
    void findById() {
        User user = userService.findById(24);
        System.out.println(user);
    }
}