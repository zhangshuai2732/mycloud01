package com.architect.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @auther ZHS
 * @create 2020/7/3 18:04
 */

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){ //发的是String ，收也是String，发送是withPayLoad,接收对应getPayload
        System.out.println("消费者1号***接收到的消息"+message.getPayload() +"\t"+serverPort);
    }
}
