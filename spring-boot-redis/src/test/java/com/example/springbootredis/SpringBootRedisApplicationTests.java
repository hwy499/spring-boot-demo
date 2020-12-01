package com.example.springbootredis;

import com.example.springbootredis.redis.util.IRedisCommonCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class SpringBootRedisApplicationTests {

    @Autowired
    IRedisCommonCommand redisCommonCommand;

    @Test
    void contextLoads() {

        redisCommonCommand.setValue("name", "1234567");
        String value = redisCommonCommand.getValue("name");
        log.info("key = name的值为：" + value);
        long res = redisCommonCommand.autoIncrement("119.135.3.191", 1);
        log.info("自增完的数" + res);
        log.info("10s后失效");
        redisCommonCommand.setValue("hwy", "18", 10, TimeUnit.SECONDS);

        redisCommonCommand.putHashValue("1", "name", "hwy");
        redisCommonCommand.putHashValue("1", "sex", "nan");
        redisCommonCommand.putHashValue("1", "age", "18");
        HashMap<String, String> map = (HashMap<String, String>) redisCommonCommand.getHashValue("1");
        log.info("map data === " + map);

        String name = (String) redisCommonCommand.getValueByHashKey("1", "name");
        log.info("name==========" + name);

        Set<Object> hashKeys = redisCommonCommand.hashKeys("1");
        log.info("hashKeys ======== " + hashKeys);

        List<Object> hashValues = redisCommonCommand.hashValues("1");
        log.info("hashValues ======= " + hashValues);


    }


}
