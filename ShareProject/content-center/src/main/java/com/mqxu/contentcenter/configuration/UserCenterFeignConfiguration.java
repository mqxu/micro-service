package com.mqxu.contentcenter.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName UserCenterFeignConfiguration
 * @Description 自定义配置Feign的日志级别配置类
 *  * 这个类不要@Configuration注解，否则会父子上下文重叠，必须挪到@ComponentScan能扫描的包以外
 * @Author mqxu
 * @Date 2020/9/30
 **/
public class UserCenterFeignConfiguration {
    @Bean
    public Logger.Level level(){
        //让Feign打印所有请求细节
        return Logger.Level.FULL;
    }
}
