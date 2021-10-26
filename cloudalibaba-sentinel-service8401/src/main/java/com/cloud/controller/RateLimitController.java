package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entity.Payment;
import com.cloud.handler.CustomerBlockHandler;
import com.cloud.utils.CommonResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 20:03
 */
@RestController
public class RateLimitController {

    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException", fallback = "fall")
    public CommonResult byResource() {
        Random random = new Random(5);
        int i = random.nextInt();
        if (i == 1 || i == 0) {
            throw new RuntimeException("异常");
        }
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020, "serial001"));
    }

    public CommonResult handleException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t 服务不可用");
    }

    public CommonResult fall() {
        return new CommonResult(500, "服务挂了");
    }


    @GetMapping("customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200,"按客户自定义",new Payment(2020,"serial003"));
    }
}
