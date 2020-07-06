package com.combat.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther ZHS
 * @create 2020/7/4 08:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9001 {
    public static void main(String[] args){
        SpringApplication.run(NacosMain9001.class,args);
    }

}
