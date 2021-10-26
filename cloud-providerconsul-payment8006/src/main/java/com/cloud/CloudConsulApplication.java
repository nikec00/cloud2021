package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/24 22:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsulApplication.class,args);
    }
}
