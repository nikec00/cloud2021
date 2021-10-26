package com.cloud.controller;

import com.cloud.client.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/10 17:54
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Autowired
    private PaymentClient paymentClient;

    @GetMapping("nacos/{id}")
    public String getNacosById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
    }

    @GetMapping("nacos/feign/{id}")
    public String getNacosFeignById(@PathVariable("id")Integer id)
    {
        return paymentClient.nacosById(id);
    }
}
