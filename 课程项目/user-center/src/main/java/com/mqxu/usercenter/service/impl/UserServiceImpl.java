package com.mqxu.usercenter.service.impl;

import com.mqxu.usercenter.dao.UserMapper;
import com.mqxu.usercenter.domain.entity.User;
import com.mqxu.usercenter.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mqxu
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);

    }
}
