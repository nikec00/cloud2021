package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/13 12:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class,args);
    }
}
