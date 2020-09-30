package com.mqxu.contentcenter.feignclient;

import com.mqxu.contentcenter.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TestUserCenterFeignClient
 * @Description 测试请求多参数用户中心
 * @Author mqxu
 * @Date 2020/9/30
 **/
@FeignClient(name = "user-center")
public interface TestUserCenterFeignClient {
    /**
     * 多参数查询
     * @param userDTO
     * @return UserDTO
     */
    @GetMapping("/users/q")
    UserDTO query (@SpringQueryMap  UserDTO userDTO);
}
