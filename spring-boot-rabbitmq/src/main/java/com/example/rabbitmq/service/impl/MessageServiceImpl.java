package com.example.rabbitmq.service.impl;

import com.example.rabbitmq.service.IMessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 消息服务接口实现类
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public boolean pushMessage(String message) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", message);
        map.put("createTime", createTime);
        // 发送消息到rabbit服务
        rabbitTemplate.convertAndSend("queue1", map);
        return false;
    }


}
