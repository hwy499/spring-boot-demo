package com.example.springbootredis.redis.util;

/**
 * desc:redis常用命令接口类
 *
 * @author hwy20
 */
public interface IRedisCommonCommand {
    /**
     * 删除key
     * @param key 要删除的key
     */
    boolean delete(String key);
    /**
     * 删除key
     * @param key 多个key
     */
    long delete(String ...key);
    /**
     * 判断key是否存在
     * @param key 要查询的key
     * @return true 存在 false 不存在
     */
    boolean hasKey(String key);



    /*----------------------String 类型相关操作------------------------------------*/
    /**
     * 设置指定key的值
     * @param key 要设置值的key
     * @return
     */
    void setValue(String key ,String value);
    /**
     * 获取指定 key 的值
     * @param key 要获取值的key
     * @return 指定 key 的值
     */
    String getValue(String key);


}
