package com.cloud.service;

import com.cloud.entity.Payment;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/22 21:51
 */
public interface PaymentService {
    int savePayment(Payment payment);

    Payment listPaymentById(Integer id);

}
