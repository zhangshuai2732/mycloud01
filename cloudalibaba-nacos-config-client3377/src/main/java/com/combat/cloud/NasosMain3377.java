package com.combat.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther ZHS
 * @create 2020/7/5 10:21
 */
@SpringBootApplication
public class NasosMain3377 {
    public static void main(String[] args){
        SpringApplication.run(NasosMain3377.class,args);
    }

    @RestController
    @RefreshScope
    public class ConfigController {

        //对应nacos配置中心对应DataId的配置内容，怎么找到DataId，查看bootstrap.properties
        @Value("${info.version}")
        private String serverConfig;

        @GetMapping(value = "/get")
        public String getConfig(){
            return serverConfig;
        }
    }
}
