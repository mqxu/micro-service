package com.mqxu.usercenter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @ClassName SwaggerConfiguration
 * @Description Swagger配置文件
 * @Author mqxu
 * @Date 2020/10/18
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * swagger 信息
     *
     * @return 页面信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "share-app Swagger文档",
                "github地址：https://github.com/mqxu/micro-service",
                "API V1.0",
                "Terms of service",
                new Contact("陶然然", "https://taoranran.cn", "taoranran@gmail.com"),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }


    /**
     * Docket配置
     *
     * @return Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mqxu.usercenter"))
                .build()
                .apiInfo(apiInfo());
    }
}
