package com.cloud.dao;

import com.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/21 11:03
 */
@Mapper
public interface OrderDAO {

    /**
     * 1.新建订单
     */
    void create(Order order);

    /**
     * 2.修改订单状态 0->1
     */
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
