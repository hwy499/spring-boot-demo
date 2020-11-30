package com.example.springbootredis.redis.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * desc:redis常用命令接口类
 *
 * @author hwy20
 */
public interface IRedisCommonCommand {
    /**
     * 删除key
     *
     * @param key 要删除的key
     */
    boolean delete(String key);

    /**
     * 删除key
     *
     * @param key 多个key
     */
    long delete(String... key);

    /**
     * 判断key是否存在
     *
     * @param key 要查询的key
     * @return true 存在 false 不存在
     */
    boolean hasKey(String key);

    /**
     * key 自动递增
     *
     * @param key       要增加的key
     * @param increment 要增加的数
     * @return 增加的数
     */
    long autoIncrement(String key, int increment);

    /**
     * key 自动递减
     *
     * @param key       要递减的key
     * @param increment 要减少的数
     * @return 减少后的数
     */
    long autoDecrement(String key, int increment);

    /*----------------------String 类型相关操作------------------------------------*/

    /**
     * 设置指定key的值
     *
     * @param key 要设置值的key
     * @return
     */
    void setValue(String key, String value);

    /**
     * 设置指定key的值 并设置过期时间
     *
     * @param key   要设置值的key
     * @param value 要设置的值
     * @param time  过期时间
     * @param unit  时间单位
     * @return
     */
    void setValue(String key, String value, long time, TimeUnit unit);

    /**
     * 获取指定 key 的值
     *
     * @param key 要获取值的key
     * @return 指定 key 的值
     */
    String getValue(String key);
    /*----------------------Hash 类型相关操作------------------------------------*/

    /**
     * 设置指定key的值
     *
     * @param key      要设置Hash对应的key
     * @param mapKey   hash key
     * @param mapValue hash value
     * @return
     */
    void putHashValue(String key, String mapKey, String mapValue);

    /**
     * 将一个map放置到指定的key
     *
     * @param key 被放置的key
     * @param map map数据
     */
    void putHashValue(String key, Map map);

    /**
     * 获取指定key的map数据
     *
     * @param key redis中的key
     * @return key对应的Map
     */
    Map getHashValue(String key);

    /**
     * 通过key获取指定map中hashKey对应的值
     *
     * @param key     redis中的key
     * @param hashKey hashMap中的key
     * @return key => hashKey对应的值
     */
    Object getValueByHashKey(String key, String hashKey);

}

