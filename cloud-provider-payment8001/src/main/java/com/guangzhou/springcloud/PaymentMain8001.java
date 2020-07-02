package com.guangzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther ZHY
 * @create 2020/6/26 17:12
 */

@SpringBootApplication  //springboot主启动注解
@EnableEurekaClient
@EnableDiscoveryClient  //使DiscoveryClient生效，控制器自动注入了DiscoveryClient
public class PaymentMain8001 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
