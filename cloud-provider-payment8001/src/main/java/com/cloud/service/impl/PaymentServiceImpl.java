package com.cloud.service.impl;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.cloud.dao.PaymentDAO;
import com.cloud.entity.Payment;
import com.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/9/22 21:51
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int savePayment(Payment payment) {
        return paymentDAO.savePayment(payment);
    }

    @Override
    public Payment listPaymentById(Integer id) {
        return paymentDAO.listPaymentById(id);
    }
}
