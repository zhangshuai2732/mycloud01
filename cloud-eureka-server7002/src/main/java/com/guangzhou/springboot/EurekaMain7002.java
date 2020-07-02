package com.guangzhou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther ZHS
 * @create 2020/6/27 20:08
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    
    public static void main(String[] args){
        SpringApplication.run(EurekaMain7002.class,args);
    }
}
