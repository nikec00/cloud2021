package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 13:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CloudPaymentHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentHystrixApplication.class,args);
    }
}
