package com.example.rabbitmq.controller;

import com.example.rabbitmq.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息接口
 */

/**
 * 消息接口
 */
@RestController
public class MessageController {

    @Autowired
    MessageProducer messageProducer;

    @GetMapping("/push")
    public String sendMessage() {
        messageProducer.send();
        return "ok";
    }

}