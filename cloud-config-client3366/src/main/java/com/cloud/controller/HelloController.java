package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/9 23:10
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${server.info}")
    private String info;

    @GetMapping("configServer")
    public String configServer() {
        return info;
    }
}
