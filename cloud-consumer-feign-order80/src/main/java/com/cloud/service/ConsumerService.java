package com.cloud.service;

import com.cloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 11:57
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface ConsumerService {

    @GetMapping("payment/listPayment")
    CommonResult listPayment(@RequestParam("id") Integer id);
}
