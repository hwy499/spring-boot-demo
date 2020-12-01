package com.example.springbootredis;

import com.example.springbootredis.redis.util.IRedisCommonCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringBootRedisApplicationTests {

    @Autowired
    IRedisCommonCommand redisCommonCommand;

    @Test
    void contextLoads() {
        long size = redisCommonCommand.sCard("setKey");
        log.info("size of setKey is "+size);
    }


}
