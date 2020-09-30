package com.mqxu.contentcenter;

import com.mqxu.contentcenter.domain.dto.UserDTO;
import com.mqxu.contentcenter.feignclient.TestBaiduFeignClient;
import com.mqxu.contentcenter.feignclient.TestUserCenterFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author mqxu
 * 测试相关功能的接口
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;



    /**
     * 测试服务发现，证明内容中心总能找到用户中心
     *
     * @return 用户中心所有实例列表
     */
    @GetMapping("/discovery")
    public List<ServiceInstance> getInstances() {
        // 查询指定服务的所有实例的信息，使用的是Spring Cloud的接口，和具体实现的组件无关
        //consul/eureka/zookeeper都可以使用
        return this.discoveryClient.getInstances("user-center");

    }

    @GetMapping("/call/hello")
    public String callUserCenter() {
        //用户中心所有的实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        //stream编程、Lambda表达式、函数式编程
        //理解这段代码的含义？它实现了什么功能？
//        String targetUrl = instances.stream()
//                .map(instance -> instance.getUri().toString() + "/user/hello")
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("当前没有实例！"));

        //所有实例的uri集合
        List<String> targetUrls = instances.stream()
                .map(instance -> instance.getUri().toString() + "/user/hello")
                .collect(Collectors.toList());
//        log.info("所有实例地址：{}",targetUrls.toString());

        //随机数
        int i = ThreadLocalRandom.current().nextInt(targetUrls.size());
        log.info("请求的目标地址：{}",targetUrls.get(i));
        return restTemplate.getForObject(targetUrls.get(i),String.class);
    }

    @GetMapping(value = "/call/ribbon")
    public String callByRibbon(){
       return restTemplate.getForObject("http://user-center/user/hello",String.class);
    }

    @Autowired
    private TestUserCenterFeignClient testUserCenterFeignClient;
    @GetMapping(value = "/test-q")
    public UserDTO query(UserDTO userDTO){
        return testUserCenterFeignClient.query(userDTO);
    }
//
//    @Autowired
//    private TestBaiduFeignClient testBaiduFeignClient;
//    @GetMapping(value = "/baidu")
//    public String baiduIndex(){
//        return this.testBaiduFeignClient.index();
//    }

}
