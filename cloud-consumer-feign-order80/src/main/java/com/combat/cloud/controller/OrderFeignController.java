package com.combat.cloud.controller;

import com.combat.cloud.service.PaymentFeignService;
import com.combat.cloud.service.PaymentFeignService4Hystrix;
import com.guangzhou.springcloud.entities.CommonResult;
import com.guangzhou.springcloud.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther ZHS
 * @create 2020/6/30 11:48
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")})
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;
    @Autowired
    private PaymentFeignService4Hystrix paymentFeignService4Hystrix;

    //此为客户端的访问地址，controller调用了自己service接口，接口去找对应微服务的哪个地址来完成接口调用，实现了Ribbon+RestTemplate
    @GetMapping(value="/consumer/payment/get/{id}")
    public CommonResult<Payment> getFeign(@PathVariable("id")Long id){
        return paymentFeignService.get(id);
    }

    //去找提供者8001的线程暂停3秒的方法，此时feign默认等待1秒
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String getFeignTimeout(){
        return paymentFeignService.getFeignTimeout();
    }

    //正常访问
    @GetMapping("/consumer/payment/hystrix/ok")
    public String getPaymentInfo_OK(){
        return paymentFeignService4Hystrix.paymentInfo_OK();
    }


    //线程暂停3秒
    //@HystrixCommand(fallbackMethod = "getPaymentInfo_Timeout_FallbackMethod",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")})
    //@HystrixCommand //使用@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFeignService4HystrixImpl.class)
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String getPaymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentFeignService4Hystrix.paymentInfo_Timeout(id);
    }

/*    //@HystrixCommand的方法有参数，fallbackMethod必须有同样的参数，否则会找不到
    public String getPaymentInfo_Timeout_FallbackMethod(Integer id){
        return "Consumer80 超时了，请稍候再试";
    }

    //全局不能有参数
    public String payment_Global_FallbackMethod(){
        return "payment_Global_FallbackMethod  Consumer80 超时了，请稍候再试";
    }*/
}
