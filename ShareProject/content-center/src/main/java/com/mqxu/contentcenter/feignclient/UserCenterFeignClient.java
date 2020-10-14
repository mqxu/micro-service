package com.mqxu.contentcenter.feignclient;

//import com.mqxu.contentcenter.configuration.GlobalFeignConfiguration;

import com.mqxu.contentcenter.configuration.UserCenterFeignConfiguration;
import com.mqxu.contentcenter.domain.dto.UserAddBonusDTO;
import com.mqxu.contentcenter.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mqxu
 * 用户中心对应的Feign客户端声明接口
 */
@FeignClient(name = "user-center", configuration = UserCenterFeignConfiguration.class)
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
     * 用户增加积分
     * @param userAddBonusDTO
     * @return
     */
    @PutMapping("/users/add-bonus")
    UserDTO addBonus(@RequestBody UserAddBonusDTO userAddBonusDTO);
}