package com.example.rabbitmq;

import com.example.rabbitmq.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 */
@Slf4j
@Component
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout msg ";
        log.info("Sender : {}", context);
        rabbitTemplate.convertAndSend("fanoutExchange", "", context);
    }

}
