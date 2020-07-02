package com.guangzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther ZHS
 * @create 2020/6/29 15:55
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
