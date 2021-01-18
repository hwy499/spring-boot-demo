package com.example.rabbitmq.controller;

import com.example.rabbitmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息推送接口
 */
@RestController
public class MessageController {

    @Autowired
    MessageProducer messageProducer;

    @GetMapping("/push")
    public String sendMessage() {
        for (int i = 0; i < 10; i++) {
            //偶数往2里发，奇数往1里发
            String key = i % 2 == 0 ? "hello.queue.2" : "hello.queue.1";
            messageProducer.send("hello.exchange.topic", key, key);
        }
        return "ok";
    }

}