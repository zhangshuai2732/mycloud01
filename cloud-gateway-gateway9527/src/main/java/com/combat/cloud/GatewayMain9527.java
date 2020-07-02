package com.combat.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther ZHS
 * @create 2020/7/1 22:02
 */

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args){
        SpringApplication.run(GatewayMain9527.class,args);
    }
}
