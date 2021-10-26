package com.cloud.feign;

import com.cloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 21:33
 */
@FeignClient("CLOUD-ALIBABA-PAYMENT")
public interface PaymentClient {

    @GetMapping("paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id")Integer id);
}
