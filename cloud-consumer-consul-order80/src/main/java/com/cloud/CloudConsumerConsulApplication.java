package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/24 23:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerConsulApplication.class,args);
    }
}
