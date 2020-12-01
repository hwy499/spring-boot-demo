package com.example.springbootredis.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
    public long autoIncrement(String key, int increment) {
        return this.redisTemplate.boundValueOps(key).increment(increment);
    }

    @Override
    public long autoDecrement(String key, int decrement) {
        return this.redisTemplate.boundValueOps(key).increment(decrement);
    }


    @Override
    public void setValue(String key, String value) {
        this.redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void setValue(String key, String value, long time, TimeUnit unit) {
        this.redisTemplate.opsForValue().set(key,value,time, unit);
    }

    @Override
    public String getValue(String key) {
        return (String) this.redisTemplate.opsForValue().get(key);
    }

    @Override
    public void putHashValue(String key, String mapKey, String mapValue) {
        this.redisTemplate.boundHashOps(key).put(mapKey,mapValue);
    }

    @Override
    public void putHashValue(String key, Map map) {
        this.redisTemplate.boundHashOps(key).putAll(map);
    }

    @Override
    public Map getHashValue(String key) {
        return redisTemplate.boundHashOps(key).entries();
    }

    @Override
    public Object getValueByHashKey(String key, String hashKey) {
        return this.redisTemplate.boundHashOps(key).get(hashKey);
    }

    @Override
    public Set<Object> hashKeys(String key) {
        return this.redisTemplate.boundHashOps(key).keys();
    }

    @Override
    public List<Object> hashValues(String key) {
     return this.redisTemplate.boundHashOps(key).values();
    }


    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
