package com.example.springbootredis;

import com.example.springbootredis.redis.util.RedisCommonCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringBootRedisApplicationTests {

    @Autowired
    RedisCommonCommand redisCommonCommand;

    @Test
    void contextLoads() {
       redisCommonCommand.setValue("name","123456");
       String value = redisCommonCommand.getValue("name");
       log.info("key = name的值为："+value);
//       boolean res =  redisCommonCommand.delete("name");
//       log.info("删除key为name的结果: "+res);
    }

}
