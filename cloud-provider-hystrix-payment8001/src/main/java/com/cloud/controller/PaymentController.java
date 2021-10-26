package com.cloud.controller;

import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 13:34
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String service_port;

    @GetMapping("hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfo_OK(id);
        log.info("****result:{}", res);
        return res;
    }

    @GetMapping("hystrix/timeOut/{id}")
    public String paymentInfo_TIMEOUT(@PathVariable("id") Integer id) {
        String res = paymentService.payment_TimeOut(id);
        log.info("****result:{}", res);
        return res;
    }

    @GetMapping("hystrix/breaker/{id}")
    public String breaker(@PathVariable("id")Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
