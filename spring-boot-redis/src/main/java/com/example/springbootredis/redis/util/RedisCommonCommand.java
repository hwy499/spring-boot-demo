package com.example.springbootredis.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author hwy20
 * redis 常用命令实现类
 */

@Component
public class RedisCommonCommand implements IRedisCommonCommand{

    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public boolean delete(String key) {
        return null == key ?  false: redisTemplate.delete(key);
    }

    @Override
    public long delete(String... key) {
        if(null == key){
            return 0;
        }
        if(key.length == 1){
            return redisTemplate.delete(key[1]) ? 1 : 0;
        }
        return  redisTemplate.delete(Arrays.asList(key));
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void setValue(String key, String value) {
        this.redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public String getValue(String key) {
        return (String) this.redisTemplate.opsForValue().get("key");
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
