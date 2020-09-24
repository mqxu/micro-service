package com.soft1851.usercenter.controller;

import com.soft1851.usercenter.domain.dto.UserDto;
import com.soft1851.usercenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author mqxu
 */
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/{id}")
    public UserDto getUserDto(@PathVariable int id){
        return userService.getUserDto(id);
    }
}
