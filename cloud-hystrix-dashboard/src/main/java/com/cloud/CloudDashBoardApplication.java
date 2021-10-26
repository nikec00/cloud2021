package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 23:39
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard //开启仪表盘
public class CloudDashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudDashBoardApplication.class,args);
    }
}
