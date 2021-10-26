package com.cloud.controller;

import com.cloud.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/18 15:59
 */
@RestController
@RequestMapping("sentinel")
@Slf4j
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;

    @GetMapping("halo")
    public String halo() {
        log.info("halo:{}", "成功");
        return sentinelService.order();
    }

    @GetMapping("test")
    public String test() {
        log.info("test:{}", "成功");
        return sentinelService.order();
    }

    @GetMapping("key/{id}")
    public String key(@PathVariable("id") Integer id) {
        return sentinelService.orderTest(id);
    }

    @GetMapping("testB")
    public String testB() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testB ok";
    }

    @GetMapping("testC")
    public String testC(@RequestParam("id") Integer id) {
        return sentinelService.orderTestC(id);
    }

}
