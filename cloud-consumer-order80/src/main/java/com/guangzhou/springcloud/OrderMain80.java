package com.guangzhou.springcloud;

        import com.guangzhou.rule.MyRule;
        import com.netflix.loadbalancer.ILoadBalancer;
        import com.netflix.loadbalancer.Server;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
        import org.springframework.cloud.netflix.ribbon.RibbonClient;

        import java.util.List;

/**
 * @auther ZHS
 * @create 2020/6/27 14:19
 */
@SpringBootApplication
@EnableEurekaClient
//name=""注意要大写，yml是小写，注册到Eureka网页显示是大写
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class,args);
    }
}
