package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 11:46
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudConsumerOpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOpenFeignApplication.class,args);
    }
}
