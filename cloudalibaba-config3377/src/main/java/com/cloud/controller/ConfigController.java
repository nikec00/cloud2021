package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/13 12:41
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${server.info}")
    private String info;

    @GetMapping("config/info")
    public String info() {
        return info;
    }
}
