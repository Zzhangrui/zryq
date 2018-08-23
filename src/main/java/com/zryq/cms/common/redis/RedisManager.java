package com.zryq.cms.common.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * @author Mark
 */
@Component
public class RedisManager {

    private int expire;

    @Resource
    private JedisPool jedisPool;


    /**
     * get value from redis
     *
     * @param key
     * @return
     */
    public byte[] get(byte[] key) {
        byte[] value;
        Jedis jedis = jedisPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * set
     *
     * @param key
     * @param value
     * @return
     */
    public byte[] set(byte[] key, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (this.expire != 0) {
                jedis.expire(key, this.expire);
            }
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * 设置hash
     *  @param key
     * @param field
     * @param value
     */
    public void hSet(byte[] key, byte[] field, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hset(key, field, value);
        } finally {
            jedis.close();
        }
    }

    /**
     * 获取Hash
     *
     * @param key
     * @param field
     */
    public byte[] hget(byte[] key, byte[] field) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hget(key, field);
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据key获取所有hash
     *
     * @param key
     * @return
     */
    public Map<byte[], byte[]> hGetAll(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hgetAll(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * 删除hash中指定的key，field
     *  @param key
     * @param field
     */
    public void hDel(byte[] key, byte[]... field) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hdel(key, field);
        } finally {
            jedis.close();
        }
    }

    /**
     * set
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public byte[] set(byte[] key, byte[] value, int expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (expire != 0) {
                jedis.expire(key, expire);
            }
        } finally {
            jedis.close();
        }
        return value;
    }

    /**
     * del
     *
     * @param key
     */
    public void del(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * size
     */
    public Long dbSize() {
        Long dbSize = 0L;
        Jedis jedis = jedisPool.getResource();
        try {
            dbSize = jedis.dbSize();
        } finally {
            jedis.close();
        }
        return dbSize;
    }

    /**
     * keys
     *
     * @param
     * @return
     */
    public Set<byte[]> keys(String pattern) {
        Set<byte[]> keys;
        Jedis jedis = jedisPool.getResource();
        try {
            keys = jedis.keys(pattern.getBytes());
        } finally {
            jedis.close();
        }
        return keys;
    }


    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
