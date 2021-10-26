package com.cloud.dao;

import com.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/22 21:41
 */
@Mapper
public interface PaymentDAO {

    int savePayment(Payment payment);

    Payment listPaymentById(@Param("id")Integer id);

}
