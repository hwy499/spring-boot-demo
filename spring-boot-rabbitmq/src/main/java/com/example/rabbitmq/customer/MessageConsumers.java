package com.example.rabbitmq.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
@Slf4j
public class MessageConsumers {

    @RabbitListener(queuesToDeclare = @Queue("queue1"))
    public void consumers1(String message) {
        log.info("队列queue1 接收的消息 is {}", message);
    }

    @RabbitListener(queuesToDeclare = @Queue("queue2"))
    public void consumers2(String message) {
        log.info("队列queue2 接收的消息 is {}", message);
    }

}

