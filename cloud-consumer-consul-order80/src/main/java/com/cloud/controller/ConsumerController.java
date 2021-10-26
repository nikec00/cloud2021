package com.cloud.controller;

import com.cloud.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/24 23:14
 */
@RestController
    @RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PROVIDER_URL = "http://PROVIDER-PAYMENT/";

    @GetMapping("getPayment")
    public CommonResult getPayment(@RequestParam("id")Integer id) {
        return restTemplate.getForObject(PROVIDER_URL + "/payment/listPayment?id=" + id, CommonResult.class);
    }
}
