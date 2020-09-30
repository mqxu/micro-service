package com.mqxu.contentcenter.feignclient;

//import com.mqxu.contentcenter.configuration.GlobalFeignConfiguration;
import com.mqxu.contentcenter.configuration.GlobalFeignConfiguration;
import com.mqxu.contentcenter.configuration.UserCenterFeignConfiguration;
import com.mqxu.contentcenter.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mqxu
 * 用户中心对应的Feign客户端声明接口
 */
@FeignClient(name = "user-center",configuration = UserCenterFeignConfiguration.class)
//@FeignClient(name = "user-center")
public interface UserCenterFeignClient {
    /**
     * http://user-center/users/{id}
     *
     * @param id
     * @return UserDTO
     */
    @GetMapping("/users/{id}")
    UserDTO findUserById(@PathVariable Integer id);

    /**
     * hello测试
     * @return String
     */
    @GetMapping("/user/hello")
    String getHello();
}