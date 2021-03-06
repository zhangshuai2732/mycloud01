package com.guangzhou.springcloud.service;

import com.guangzhou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @auther ZHS
 * @create 2020/6/27 09:43
 */
public interface PaymentService {

    //直接复制dao
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
