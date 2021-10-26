package com.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/13 09:47
 */
@FeignClient(value = "NACOS-CLIENT-PAYMENT")
public interface PaymentClient
{
    @GetMapping("payment/nacos/{id}")
    public String nacosById(@PathVariable("id")Integer id);
}
