package com.combat.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther ZHS
 * @create 2020/7/4 08:51
 */

@RestController
public class NacosController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public String echo(@PathVariable("id") Integer id){
        return "hello nacos!\tserverPort:"+serverPort+"\t"+id;
    }
}
