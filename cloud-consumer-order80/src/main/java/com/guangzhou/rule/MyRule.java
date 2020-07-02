package com.guangzhou.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther ZHS
 * @create 2020/6/30 08:10
 */

@Configuration
public class MyRule {

    @Bean
    public IRule myRule2(){
        return new RandomRule();
        //return new RoundRobinRule(); //默认：轮询
    }
}
