package com.guangzhou.springcloud.controller;

import com.guangzhou.springcloud.entities.CommonResult;
import com.guangzhou.springcloud.entities.Payment;
import com.guangzhou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther ZHS
 * @create 2020/6/27 09:53
 * 需求：读请求、写请求
 */

@RestController
@Slf4j      //lombok自动生成 Logger log = LoggerFactory.getLogger(HelloWorld.class);
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")    //取出配置文件的值与字段映射，只能取简单类型，不能取map
    private String serverPost;

    /**
     * 服务发现，作用获取服务信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 服务发现
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        //增强for快捷键iter，普通itar
        for (String service : services) {
            log.info("********找到的服务有:"+service);
            //********找到的服务有:cloud-payment-service
        }
        //获取服务名为XX的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            //CLOUD-PAYMENT-SERVICE	192.168.1.10	8001	http://192.168.1.10:8001
        }
        return this.discoveryClient;
    }

    //读请求
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id")Long id){

        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*************************查询结果："+paymentById);
        if(paymentById != null){
            return new CommonResult(200,"查询成功,serverPort="+serverPost,paymentById);
        }else {
            return new CommonResult(444,"没有对应记录，查询id="+id,paymentById);
        }
    }

    //写请求
    @PostMapping (value = "/payment/create")
    public CommonResult  create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort="+serverPost,result);
        }else {
            return new CommonResult(444,"插入数据库失败",result);
        }
    }

}
