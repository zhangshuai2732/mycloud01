package com.guangzhou.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther ZHS
 * @create 2020/6/27 14:33
 */

@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced  //实现RestTemplate负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
