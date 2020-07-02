package com.combat.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @auther ZHS
 * @create 2020/7/2 10:19
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {
    public static void main(String[] args){
        SpringApplication.run(ConfigMain3344.class,args);
    }
}
