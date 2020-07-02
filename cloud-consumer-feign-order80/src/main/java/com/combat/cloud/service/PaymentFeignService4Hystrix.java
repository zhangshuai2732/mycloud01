package com.combat.cloud.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther ZHS
 * @create 2020/7/1 10:41
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFeignService4HystrixImpl.class)
//去找注册中心的CLOUD-PROVIDER-HYSTRIX-PAYMENT服务
//也就是spring.application.name: cloud-provider-hystrix-payment的微服务
//对应模块  cloud-provider-hystrix-payment8001
public interface PaymentFeignService4Hystrix {


    @GetMapping(value = "/payment/hystrix/ok")
    public String paymentInfo_OK();

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id);
}
