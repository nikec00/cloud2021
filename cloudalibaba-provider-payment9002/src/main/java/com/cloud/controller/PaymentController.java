package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/10 17:28
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("nacos/{id}")
    public String nacosById(@PathVariable("id")Integer id) {
        return "nacos registry, savePort:" + serverPort + "\t" + "id:" + id;
    }
}
