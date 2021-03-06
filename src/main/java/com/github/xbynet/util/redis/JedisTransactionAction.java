package com.github.xbynet.util.redis;

import redis.clients.jedis.Transaction;

/**
 * 事务动作执行器
 * Created by taojw.
 */
public interface JedisTransactionAction extends IJedisAction{
    void action(Transaction client);
}
