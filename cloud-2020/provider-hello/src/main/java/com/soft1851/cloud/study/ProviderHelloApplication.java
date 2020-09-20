package com.soft1851.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mqxu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHelloApplication.class, args);
    }

}
