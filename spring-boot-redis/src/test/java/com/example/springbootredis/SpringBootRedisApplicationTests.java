package com.example.springbootredis;

import com.example.springbootredis.redis.util.IRedisCommonCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class SpringBootRedisApplicationTests {

    @Autowired
    IRedisCommonCommand redisCommonCommand;

    @Test
    void contextLoads() {
        redisCommonCommand.set("ecologyToken","hwy..123456");
        redisCommonCommand.set("token","123ad1ad1as2d1asd1asd",100, TimeUnit.MINUTES);
        String ecologyToken = redisCommonCommand.get("ecologyToken");
        log.info("ecologyToken::",ecologyToken);
    }


}
