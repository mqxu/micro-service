package com.mqxu.usercenter.service;

import com.mqxu.usercenter.domain.entity.User;

/**
 * @author mqxu
 */
public interface UserService {
    /**
     * 根据id获得用户详情
     * @param id
     * @return User
     */
    User findById(Integer id);
}
