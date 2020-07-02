package com.combat.cloud.controller;

import com.combat.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

/**
 * @auther ZHS
 * @create 2020/7/1 07:57
 */

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/ok")
    public String paymentInfo_OK(){
        return paymentService.paymentInfo_OK();

    }

    /**
     * 线程暂停3秒
     */
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Timeout(id);

    }

    /**
     * 服务熔断
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        return paymentService.paymentCircuitBreaker(id);

    }
}
