package com.cloud.hanle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.utils.CommonResult;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/19 21:09
 */
public class ConsumerBlockHandler {

    /**
     * 只负责sentinel控制台违规
     * @param id
     * @param e
     * @return
     */
    public static CommonResult handlerException(Integer id, BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "handlerException");
    }

    /**
     * 只负责sentinel控制台违规
     * @param id
     * @param e
     * @return
     */
    public static CommonResult handlerException2(Integer id, BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "handlerException2");
    }

    /**
     * 只负责业务异常
     * @param id
     * @param e
     * @return
     */
    public static CommonResult fall(Integer id,Throwable e) {
        return new CommonResult(500, "服务器出错,异常：" + e.getMessage());
    }
}
