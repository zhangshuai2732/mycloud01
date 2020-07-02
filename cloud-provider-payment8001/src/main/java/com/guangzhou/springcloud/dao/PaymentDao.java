package com.guangzhou.springcloud.dao;

import com.guangzhou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @auther ZHS
 * @create 2020/6/27 09:02:07
 * 使用mybatis时，推荐使用@mapper代替@Repository
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
