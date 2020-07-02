package com.combat.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther ZHS
 * @create 2020/6/30 16:01
 */

@Configuration
public class FeignConfig {

    //feignClient配置日志级别
    @Bean
    public Logger.Level feignLoggerLevel(){
        //请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
