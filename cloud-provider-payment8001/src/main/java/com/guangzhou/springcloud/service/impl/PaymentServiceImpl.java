package com.guangzhou.springcloud.service.impl;

import com.guangzhou.springcloud.dao.PaymentDao;
import com.guangzhou.springcloud.entities.Payment;
import com.guangzhou.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther ZHS
 * @create 2020/6/27 09:45
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
