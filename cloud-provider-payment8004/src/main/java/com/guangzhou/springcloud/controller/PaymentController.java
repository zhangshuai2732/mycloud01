package com.guangzhou.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther ZHS
 * @create 2020/6/29 15:57
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 简单测试 访问服务器的zookeeper
     * @return
     */
    @GetMapping("/payment/zk")
    public String zk(){
        return "SpringCloud with zookeeper:\t"+serverPort+ "\t" +UUID.randomUUID().toString();
    }
}
