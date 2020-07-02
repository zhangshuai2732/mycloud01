package com.combat.cloud.service;

import com.guangzhou.springcloud.entities.CommonResult;
import com.guangzhou.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther ZHS
 * @create 2020/6/30 11:47
 */
@Component
@FeignClient( name = "CLOUD-PAYMENT-SERVICE")
//去找哪个微服务,对于注册中心的服务名称
public interface PaymentFeignService {

    //去找对应微服务的哪个地址来完成接口调用
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id);

    //去找提供者8001的线程暂停3秒的方法
    @GetMapping(value = "/payment/feign/timeout")
    public String getFeignTimeout();
}

