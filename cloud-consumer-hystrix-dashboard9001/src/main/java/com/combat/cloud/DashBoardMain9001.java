package com.combat.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.sun.org.apache.xpath.internal.SourceTreeManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @auther ZHS
 * @create 2020/7/1 17:55
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardMain9001 {
    public static void main(String[] args){
        SpringApplication.run(DashBoardMain9001.class,args);
    }
}
