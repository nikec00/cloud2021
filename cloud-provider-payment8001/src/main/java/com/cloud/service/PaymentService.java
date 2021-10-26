package com.cloud.service;

import com.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/22 21:51
 */
public interface PaymentService {
    int savePayment(Payment payment);

    Payment listPaymentById(Integer id);

}
