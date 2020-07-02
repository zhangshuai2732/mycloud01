package com.guangzhou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther ZHS
 * @create 2020/6/27 17:29
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args){
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
