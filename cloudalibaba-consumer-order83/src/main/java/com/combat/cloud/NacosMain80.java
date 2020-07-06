package com.combat.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther ZHS
 * @create 2020/7/4 09:19
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain80 {
    public static void main(String[] args){
        SpringApplication.run(NacosMain80.class,args);
    }

    @RestController
    public class NacosController{

        @Autowired
        private RestTemplate restTemplate;

        /**
         * 方法1：注入 LoadBalancerClient，alibaba文档使用
         */
        @Autowired
        private LoadBalancerClient loadBalancerClient;

        @GetMapping("/consumer/payment/get/{id}")
        public String payment(@PathVariable Integer id){
            ServiceInstance serviceInstance = loadBalancerClient.choose("cloud-nacos-provider");
            String path = String.format("http://%s:%s/payment/get/%d", serviceInstance.getHost(), serviceInstance.getPort(), id);
            System.out.println("request path:\t"+path);

            return restTemplate.getForObject(path,String.class);
        }

        /**
         *  方法2：RestTemplate 注解@LoadBalanced，Eureka服务名要大写，nacos服务名小写
         */
        @GetMapping("/consumer/payment2/get/{id}")
        public String payment2(@PathVariable Integer id){

            String path = String.format("http://%s/payment/get/%d","cloud-nacos-provider",id);
            return restTemplate.getForObject(path,String.class);
        }
    }

    //@LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
