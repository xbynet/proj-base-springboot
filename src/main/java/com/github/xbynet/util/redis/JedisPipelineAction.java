package com.github.xbynet.util.redis;

import redis.clients.jedis.Pipeline;

/**
 * Created by taojw.
 */
public interface JedisPipelineAction extends IJedisAction{
    void action(Pipeline client);
}
