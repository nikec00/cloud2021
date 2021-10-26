package com.consumer.controller;

import com.cloud.entity.Payment;
import com.cloud.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/22 22:26
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    // 因为生产者是集群模式下，所以访问的url路径是不能写死的。可以通过服务名称去访问
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("savePayment")
    public CommonResult savePayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/savePayment", payment, CommonResult.class);
    }

    @GetMapping("listPayment")
    public CommonResult listPayment(@RequestParam("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/listPayment?id=" + id, CommonResult.class);
    }

    @GetMapping("getPayment")
    public CommonResult getPayment(@RequestParam Integer id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/listPayment?id=" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(500,"查询失败");
        }
    }

}
