package com.cloud.service;

import com.cloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/21 20:37
 */
public interface OrderService {

    /**
     * 1.新建订单
     */
    void create(Order order);

}
