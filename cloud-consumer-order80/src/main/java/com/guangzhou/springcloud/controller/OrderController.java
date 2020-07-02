package com.guangzhou.springcloud.controller;

import com.guangzhou.springcloud.entities.CommonResult;
import com.guangzhou.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther ZHS
 * @create 2020/6/27 14:28
 */

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        //消费者请求的地址http://localhost[:80]/consumer/payment/get/1
        //到提供者请求地址http://localhost:8001/payment/get/1
    }

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        CommonResult<Payment>  commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        log.info("commonResult = "+commonResult);
        return commonResult;
    }

}
