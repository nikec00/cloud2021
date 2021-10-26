package com.cloud.controller;

import com.cloud.dao.PaymentDAO;
import com.cloud.entity.Payment;
import com.cloud.service.PaymentService;
import com.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/22 21:52
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("savePayment")
    public CommonResult savePayment(@RequestBody Payment payment) {
        int flag = paymentService.savePayment(payment);
        log.info("插入结果：{}", flag);
        if (flag > 0) {
            return new CommonResult(200, "保存成功", null);
        } else {
            return new CommonResult(500, "保存失败", null);
        }
    }

    @GetMapping("listPayment")
    public CommonResult listPayment(@RequestParam("id") Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment = paymentService.listPaymentById(id);
        log.info("读取数据!!：{}", payment);
        return new CommonResult(200, "查询成功,serverPort:" + port, payment);

    }
}
