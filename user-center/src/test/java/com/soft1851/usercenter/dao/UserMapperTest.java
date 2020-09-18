package com.soft1851.usercenter.dao;

import com.soft1851.usercenter.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void get() {
        User user = userMapper.selectByPrimaryKey(2);
        System.out.println(user);
    }
}