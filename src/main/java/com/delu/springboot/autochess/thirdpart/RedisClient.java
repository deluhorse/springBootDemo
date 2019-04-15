package com.delu.springboot.autochess.thirdpart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by delu on 2019-03-30.
 */
@Component
public class RedisClient {

    private static Jedis jedis;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    private Jedis getJedis(){
        if(jedis == null){
            jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
            return jedis;
        }
        return jedis;
    }


    /**
     * 通过key删除
     * @param key
     */
    public void del(String key){
        this.getJedis().del(key);
    }

    /**
     * 添加key value 并且设置存活时间
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key,String value,int liveTime){
        this.set(key, value);
        this.getJedis().expire(key, liveTime);
    }
    /**
     * 添加key value
     * @param key
     * @param value
     */
    public void set(String key,String value){
        this.getJedis().set(key, value);
    }

    /**
     * 获取redis value (String)
     * @param key
     * @return
     */
    public String get(String key){
        String value = this.getJedis().get(key);
        return value;
    }

    /**
     * 通过正则匹配keys
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        return this.getJedis().keys(pattern);
    }

    /**
     * 检查key是否已经存在
     * @param key
     * @return
     */
    public boolean exists(String key){
        return this.getJedis().exists(key);
    }
}
