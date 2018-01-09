package com.github.xbynet.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

/**
 * Created by taojw .
 */
@Component
public class RedisTest {
	
    @Autowired
    private JedisTemplate jedisTemplate;

    public void test(){
        final String key="jedis:test:1";
        String res= jedisTemplate.execute(new JedisAction<String>() {
            @Override
            public String action(Jedis client) {
                String res=client.setex(key,60,"HelloWorld!");
                return res;
            }
        });
        System.out.println(res);
    }
}
