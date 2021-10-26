package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 20:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9004Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment9004Application.class,args);
    }
}
