package com.cloud.controller;

import com.cloud.entity.Payment;
import com.cloud.utils.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 20:39
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    public static Map<Integer, Payment> dataMap = new HashMap<>(4);

    static {
        dataMap.put(1, new Payment(1, UUID.randomUUID().toString()));
        dataMap.put(2, new Payment(2, UUID.randomUUID().toString()));
        dataMap.put(3, new Payment(3, UUID.randomUUID().toString()));
        dataMap.put(4, new Payment(4, UUID.randomUUID().toString()));
    }

    @GetMapping("paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id")Integer id) {
        Payment payment = dataMap.get(id);
        return new CommonResult(200,"from mysql,serverPort:" + port,payment);
    }
}
