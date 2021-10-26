package com.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.utils.CommonResult;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 20:21
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444,e.getClass().getCanonicalName() + "\t handlerException");
    }

    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444,e.getClass().getCanonicalName() + "\t handlerException2");
    }
}
