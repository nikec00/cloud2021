package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 15:12
 */
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT",fallback = ConsumerFallBackService.class)
public interface ConsumerService {

    @GetMapping("payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id")Integer id);

    @GetMapping("payment/hystrix/timeOut/{id}")
    String paymentInfo_TIMEOUT(@PathVariable("id")Integer id);
}
