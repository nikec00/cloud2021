package com.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/24 23:13
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //让restTemplate具有负载均衡的作用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
