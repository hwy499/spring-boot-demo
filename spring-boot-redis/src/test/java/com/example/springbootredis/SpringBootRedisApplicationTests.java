package com.example.springbootredis;

import com.example.springbootredis.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        UserEntity entity = new UserEntity(1,"何文垚","男");
        ValueOperations<String,UserEntity> operations = redisTemplate.opsForValue();
        operations.set("1",entity);
        boolean exits  = redisTemplate.hasKey("1");
        System.out.println("是否存在"+exits);
        UserEntity entity1 = (UserEntity) redisTemplate.opsForValue().get("1");

    }

}
