package com.smart.car.record.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 *  * Component和 Configuration作为配置类注解的差别（能理解为单例和多例）,在于代理。
 *  * 只有在代理的时候，才会有区别。不然都是同一个单例
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Component
public class RedisConfig {

    /**
     * RedisTemplate相关配置(序列化机制对象)，主流方式二
     * 目的就是：将JavaBean弄成Json的样式放进redis：修改RedisTemplate的序列化机制，在配置类中配置支持字符串序列化的方法
     * @param connectionFactory LettuceConnectionFactory
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        // 设置值序列化方式:值采用json序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    /**
     * RedisTemplate相关配置(序列化机制对象)，传统方式一，
     * @param redisConnectionFactory
     * @return
     */
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//        // 配置连接工厂
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        // 设置值序列化方式:值采用json序列化
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        //使用StringRedisSerializer来序列化和反序列化redis的key值
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
}