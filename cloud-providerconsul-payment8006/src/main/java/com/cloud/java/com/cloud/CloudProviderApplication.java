package com.cloud.java.com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/22 21:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderApplication.class,args);
    }
}
