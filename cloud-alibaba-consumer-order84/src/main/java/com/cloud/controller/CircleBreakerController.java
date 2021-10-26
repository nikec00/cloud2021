package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.entity.Payment;
import com.cloud.feign.PaymentClient;
import com.cloud.hanle.ConsumerBlockHandler;
import com.cloud.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 20:53
 */
@RestController
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentClient paymentClient;

    private final static String SERVICE_URL = "http://CLOUD-ALIBABA-PAYMENT/";

    @GetMapping("consumer/fallback/{id}")
    @SentinelResource(value = "consumerFallback", blockHandlerClass = ConsumerBlockHandler.class, blockHandler = "handlerException",
            fallbackClass = ConsumerBlockHandler.class, fallback = "fall", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult consumerFallback(@PathVariable("id") Integer id) {
        CommonResult res = restTemplate.getForObject(SERVICE_URL + "paymentSQL/" + id, CommonResult.class);
        if (id == 5) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (res.getData() == null) {
            throw new NullPointerException("NullPointerException,空指针异常");
        }
        return res;
    }

    @GetMapping("consumer/feign/fallback/{id}")
    @SentinelResource(value = "commonResultFeignFallback",blockHandlerClass = ConsumerBlockHandler.class,blockHandler = "handlerException",
            fallbackClass = ConsumerBlockHandler.class,fallback = "fall",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult commonResultFeignFallback(@PathVariable("id") Integer id) {
        CommonResult result = paymentClient.paymentSQL(id);
        if (id == 5) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,空指针异常");
        }
        return result;
    }
}
