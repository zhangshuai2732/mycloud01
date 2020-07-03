package com.combat.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther ZHS
 * @create 2020/7/2 14:14
 */

@RestController
@RefreshScope
public class ConfigClientController {

    //从http://config-3344.com读取，master分支上的config-dev.yml的config.info
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get/config")
    public String getConfigInfo(){
        return configInfo;
    }
}
