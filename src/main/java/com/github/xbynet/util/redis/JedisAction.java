package com.github.xbynet.util.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by taojw .
 */
public interface JedisAction<T> extends IJedisAction{
    T action(Jedis client);
}
