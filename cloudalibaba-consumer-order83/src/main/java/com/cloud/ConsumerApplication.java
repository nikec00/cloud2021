package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/10 17:48
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 开启feign注解支持
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
