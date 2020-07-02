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
import java.util.concurrent.TimeUnit;

/**
 * @auther ZHS
 * @create 2020/6/27 09:53
 * 需求：读请求、写请求
 */

@RestController
@Slf4j      //lombok自动生成 Logger log = LoggerFactory.getLogger(HelloWorld.class);
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //取出配置文件的值与字段映射，只能取简单类型，不能取map
    @Value("${server.port}")
    private String serverPost;

    /**
     * 服务发现，作用获取服务信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 服务发现
     * 2020-06-28 11:47:19.065  INFO 5096 --- [nio-8001-exec-2] c.g.s.controller.PaymentController       : ********找到的服务有:cloud-payment-service
     * 2020-06-28 11:47:19.065  INFO 5096 --- [nio-8001-exec-2] c.g.s.controller.PaymentController       : CLOUD-PAYMENT-SERVICE	192.168.1.10	8001	http://192.168.1.10:8001
     * 2020-06-28 11:47:19.066  INFO 5096 --- [nio-8001-exec-2] c.g.s.controller.PaymentController       : CLOUD-PAYMENT-SERVICE	192.168.1.10	8002	http://192.168.1.10:8002
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        //增强for快捷键iter，普通itar
        for (String service : services) {
            log.info("********找到的服务有:"+service);
        }
        //获取服务名为XX的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    //读请求
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){

        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果："+paymentById);
        if(paymentById != null){
            return new CommonResult<Payment>(200,"查询成功,serverPort="+serverPost,paymentById);
        }else {
            return new CommonResult<Payment>(444,"没有对应记录，查询id="+id,paymentById);
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

    /**
     * 当前线程暂停3秒
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String getFeignTimeout() {
        //当前线程暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "执行完毕";
    }
}
