package com.cloud.controller;

import com.cloud.service.ConsumerService;
import com.cloud.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 12:00
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("getPaymentById")
    public CommonResult getPaymentId(@RequestParam("id") Integer id) {
        return consumerService.listPayment(id);
    }
}
