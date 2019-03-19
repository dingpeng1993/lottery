package com.dingpeng.java.exercise.lottery.resource.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author dp
 * Date: 2019/3/12 14:49
 * Description: TODO
 */
@TestConfiguration
public class RedisTestConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return null;
    }
}
