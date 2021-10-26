package com.cloud.controller;

import com.cloud.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 15:13
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("hystrix/ok/{id}")
    public String consumer_OK(@PathVariable("id") Integer id) {
        return consumerService.paymentInfo_OK(id);
    }

    @GetMapping("hystrix/timeOut/{id}")
    @HystrixCommand(fallbackMethod = "timeOutMethod",
    commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    public String consumer_TIMEOUT(@PathVariable("id") Integer id) {
        return consumerService.paymentInfo_TIMEOUT(id);
    }

    public String timeOutMethod(@PathVariable("id") Integer id){
        return "消费者服务器繁忙，请稍后再试~~";
    }
}
