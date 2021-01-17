package com.example.rabbitmq.service;

/**
 * 消息服务接口
 */
public interface IMessageService {
    /**
     * 推送消息
     * @param message
     * @return
     */
    boolean pushMessage(String message);
}
