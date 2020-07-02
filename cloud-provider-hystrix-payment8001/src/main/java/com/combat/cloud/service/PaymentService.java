package com.combat.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @auther ZHS
 * @create 2020/7/1 07:46
 */

@Service
public class PaymentService {

    public String paymentInfo_OK(){
        return Thread.currentThread().getName()+ "paymentInfo_ok";
    }

    /**
     * 指定服务降级方法：fallbackMethod = "paymentInfo_Timeout_Handler"
     * commandProperties：超过3秒后，调用fallbackMethod
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler",
                    commandProperties = {@HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})

    public String paymentInfo_Timeout(Integer id){
        int timeoutNumber = 4;
        try {
            TimeUnit.SECONDS.sleep(timeoutNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"paymentInfo_timeout+\t"
                +" ***耗时 "+timeoutNumber+"秒***";
    }

    //fallbackMethod 服务降级方法
    public String paymentInfo_Timeout_Handler(Integer id){
        return Thread.currentThread().getName()+"paymentInfo_Timeout_Handler+\t" +"请稍候再试";
    }

    /**
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallbackMethod",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true")
           //@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10") //默认20
           //@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="100000")//默认5000
           //@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")//默认50
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t 调用成功，流水号： "+serialNumber;
    }
    public String paymentCircuitBreaker_fallbackMethod(Integer id){
        return "id不能为负数，请稍候再试";
    }
}
