package com.dingpeng.java.exercise.lottery.resource.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author dp
 * Date: 2019/3/11 14:45
 * Description: @SpringBootConfiguration继承自@Configuration，二者功能也一致，标注当前类是配置类，
 * 并会将当前类内声明的一个或多个以@Bean注解标记的方法的实例纳入到spring容器中，并且实例名就是方法名。
 */

@SpringBootConfiguration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String hostName;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.database}")
    private Integer dataBase;

    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private Duration maxWait;

    @Value("${spring.redis.lettuce.pool.max-idle}")
    private Integer maxIdle;

    @Value("${spring.redis.lettuce.pool.min-idle}")
    private Integer minIdle;

    @Value("${spring.redis.timeout}")
    private String timeout;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        //单机版redis
        RedisStandaloneConfiguration redisStandaloneConfiguration = createRedisConfig();
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        //指定jedisPoolConifig来修改默认的连接池构造器
        builder.poolConfig(createJedisPoolConfig());
        JedisClientConfiguration jedisClientConfiguration = builder.build();
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }

    @Bean("redisTemplate")
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory){
        //创建一个模板类
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        //将redis连接工厂设置到模板类中
        template.setConnectionFactory(factory);
        //序列化器，将对象序列化为JSON
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        //json转对象类
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(om);
        //设置value的序列化采用Jackson2JsonRedisSerializer
        template.setValueSerializer(serializer);
        //设置值的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        //（初始化操作）加载配置后执行
        template.afterPropertiesSet();
        return template;
    }

    private JedisPoolConfig createJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWait.toMillis());
        return jedisPoolConfig;
    }

    private RedisStandaloneConfiguration createRedisConfig() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(dataBase);
        return redisStandaloneConfiguration;
    }

}
