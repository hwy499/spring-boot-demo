package com.example.springbootredis.redis.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
    Object getValueByHashKey(String key, Object hashKey);

    /**
     * 获取所有的hash-key
     *
     * @param key 要获取的hash的redis key
     * @return hash-key集合
     */
    Set<Object> hashKeys(String key);

    /**
     * 获取所有的hash-value
     *
     * @param key 要获取的hash-value的redis key
     * @return hash-value List
     */
    List<Object> hashValues(String key);

    /**
     * 删除redis key对应中的hash key
     *
     * @param key      redis key
     * @param hashKeys 1-n 个 hashKeys
     * @return 删除结果
     */
    long deleteHashKey(String key, Object... hashKeys);

    /**
     * 判断redis key对应中的hash key是否存在
     *
     * @param key     redis key
     * @param hashKey hashKey
     * @return true 存在 false 不存在
     */
    boolean isNotEmpty(String key, Object hashKey);


    /*----------------------Set 类型相关操作------------------------------------*/

    /**
     * 添加一个到多个set的值
     * @param name setKey
     * @param values 1-n 多个值
     * @return 返回成功添加的个数
     */
    long sAdd(String name,Object... values);
    /**
     * 获取 key 对应的集合的所有成员
     * @param key redis-key
     * @return 所有成员
     */
    Set<Object> sMembers(String key);
    /**
     * 检查 value 是否是 key 对应的集合的成员
     * @param key redis - key
     * @param value value
     * @return true 是 false 否
     */
    boolean sisMember(String key,String value);
    /**
     * 从集合的右侧（尾部）移除一个成员，并将其返回
     * @param key redis - key
     * @return 移除的成员
     */
    Object sPop(String key);
    /**
     * 在 key 对应的集合中删除某些值
     * @param key redis - key
     * @param values 要删除的某些值
     * @return 删除的个数
     */
    long sRem(String key,Object... values);
    /**
     * 获取key对应的集合中元素个数
     * @param key redis - key
     * @return key对应的集合中元素个数
     */
    long sCard(String key);

    /**
     * 从key对应的集合中随机获取 numbers 个元素
     * 每一位都是随机的
     * @param key redis - key
     * @param count 要获取几个
     * @return numbers个成员
     */
    List<Object> sRandMember(String key, long count);


}

