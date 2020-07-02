package com.combat.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @auther ZHS
 * @create 2020/7/1 16:59
 */
@Component
public class PaymentFeignService4HystrixImpl implements PaymentFeignService4Hystrix {

    @Override
    public String paymentInfo_OK() {
        return "paymentInfo_OK() 服务器忙，请稍候再试";
    }

    @Override
    public String paymentInfo_Timeout(Integer ids) {
        return "paymentInfo_Timeout() 服务器忙，请稍候再试";
    }
}
