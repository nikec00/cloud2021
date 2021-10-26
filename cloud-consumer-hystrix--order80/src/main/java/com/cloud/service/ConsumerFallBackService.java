package com.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/3 21:37
 */
@Component
@SuppressWarnings("all")
public class ConsumerFallBackService implements ConsumerService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "对方服务器已宕机，请稍后再试";
    }

    @Override
    public String paymentInfo_TIMEOUT(Integer id) {
        return "对方服务器已宕机，请稍后再试";
    }
}
