package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/23 20:51
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerApplication.class,args);
    }
}
