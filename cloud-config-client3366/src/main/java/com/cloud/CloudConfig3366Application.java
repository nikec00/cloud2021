package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/10 11:35
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfig3366Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig3366Application.class,args);
    }
}
