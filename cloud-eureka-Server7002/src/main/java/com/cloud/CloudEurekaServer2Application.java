package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/23 21:55
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer2Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer2Application.class,args);
    }
}
