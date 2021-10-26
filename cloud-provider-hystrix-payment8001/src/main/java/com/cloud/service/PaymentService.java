package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 13:30
 */
@Service
@DefaultProperties(defaultFallback = "payment_Global_defaultFallBack")
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK，id：" + id + "\t" + "O(∩_∩)O~~~";
    }

    @HystrixCommand(fallbackMethod = "fallBackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String payment_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "payment_TimeOut，id：" + id + "\t" + "O(∩_∩)O~~~" + "耗时" + 1 + "s";
    }

    public String fallBackMethod(Integer id) {
        return "运行异常，请稍后再试/(ㄒoㄒ)/~~" + id;
    }

    public String payment_Global_defaultFallBack() {
        return "服务器繁忙";
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50") // 失败率多少后开启断路器跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "调用成功！！！流水号：" + uuid;
    }

    public String paymentCircuitBreaker_fallBack(Integer id){
        return "id不能为负数，调用失败！！ id:" + id;
    }
}
