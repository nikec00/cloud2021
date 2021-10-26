package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/9 22:47
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClientApplication.class,args);
    }
}
