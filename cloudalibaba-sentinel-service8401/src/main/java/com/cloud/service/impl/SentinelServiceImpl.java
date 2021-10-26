package com.cloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.cloud.service.SentinelService;
import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 09:45
 */
@Service
public class SentinelServiceImpl implements SentinelService {
    @Override
    @SentinelResource(value = "order")
    public String order() {
        return "未限流";
    }

    @Override
    @SentinelResource(value = "orderTest", blockHandler = "blockHandler", fallback = "fall")
    public String orderTest(Integer id) {
        if (id == 0) {
            throw new RuntimeException("异常!");
        }
        return "demo ok";
    }

    @Override
    @SentinelResource(value = "orderTestC",fallback = "fall", blockHandler = "blockHandler")
    public String orderTestC(Integer id) {
        if (id == 0) {
            throw new RuntimeException("异常");
        }
        return "testC ok!!";
    }

    public String blockHandler(Integer id, BlockException e) {
        if (e instanceof FlowException) {
            return "当前请求过于火爆,您已被流控!!";
        }
        if (e instanceof DegradeException) {
            return "当前请求过于火爆,您已被降级!!";
        }
        if (e instanceof ParamFlowException) {
            return "当前请求过于火爆,您已被热点参数限流!!";
        }
        return "服务器快爆了,请稍后再试!";
    }

    public String fall(Integer id) {
        return "服务器出错了";
    }
}
