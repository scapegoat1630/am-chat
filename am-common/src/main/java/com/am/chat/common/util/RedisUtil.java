package com.am.chat.common.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis缓存辅助类
 *
 */
public final class RedisUtil {
    private RedisUtil() {
    }

    private static RedisTemplate<Serializable, Serializable> redisTemplate = null;
    private static Integer EXPIRE =600;

    // 获取连接
    private static RedisTemplate<Serializable, Serializable> getRedis() {
        if (redisTemplate == null) {
            synchronized (RedisUtil.class) {
                if (redisTemplate == null) {
                    WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
                    redisTemplate = (RedisTemplate<Serializable, Serializable>)wac.getBean("redisTemplate");
                }
            }
        }
        return redisTemplate;
    }

    public static final Serializable get(final Serializable key) {
        expire(key, EXPIRE);
        return getRedis().boundValueOps(key).get();
    }

    public static final Set<Serializable> getAll(final String pattern) {
        Set<Serializable> values = new HashSet<>();
        Set<Serializable> keys = getRedis().keys(pattern);
        for (Serializable key : keys) {
            expire(key.toString(), EXPIRE);
            values.add(getRedis().opsForValue().get(key));
        }
        return values;
    }

    public static final void set(final Serializable key, final Serializable value, int seconds) {
        getRedis().boundValueOps(key).set(value);
        expire(key, seconds);
    }

    public static final void set(final String key, final Serializable value) {
        getRedis().boundValueOps(key).set(value);
        expire(key, EXPIRE);
    }

    public static final Boolean exists(final String key) {
        return getRedis().hasKey(key);
    }

    public static final void del(final String key) {
        getRedis().delete(key);
    }

    public static final void delAll(final String pattern) {
        getRedis().delete(getRedis().keys(pattern));
    }

    public static final String type(final String key) {
        expire(key, EXPIRE);
        return getRedis().type(key).getClass().getName();
    }

    /**
     * 在某段时间后失效
     * 
     * @return
     */
    public static final Boolean expire(final Serializable key, final int seconds) {
        return getRedis().expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     * 在某个时间点失效
     * 
     * @param key
     * @param unixTime
     * @return
     */
    public static final Boolean expireAt(final Serializable key, final long unixTime) {
        return getRedis().expireAt(key, new Date(unixTime));
    }

    public static final Long ttl(final Serializable key) {
        return getRedis().getExpire(key, TimeUnit.SECONDS);
    }

    public static final void setrange(final Serializable key, final long offset, final String value) {
        expire(key, EXPIRE);
        getRedis().boundValueOps(key).set(value, offset);
    }

    public static final String getrange(final Serializable key, final long startOffset, final long endOffset) {
        expire(key, EXPIRE);
        return getRedis().boundValueOps(key).get(startOffset, endOffset);
    }

    public static final Serializable getSet(final Serializable key, final String value) {
        expire(key, EXPIRE);
        return getRedis().boundValueOps(key).getAndSet(value);
    }
    
    // 未完，待续...
}
