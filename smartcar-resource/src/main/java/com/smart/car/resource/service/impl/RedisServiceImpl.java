package com.smart.car.resource.service.impl;

import com.smart.car.resource.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@Service
@AllArgsConstructor
public class RedisServiceImpl implements RedisService {
    private final RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public boolean exist(String chargingrule) {
        ValueOperations<String, Serializable> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(chargingrule) != null ? true : false;
    }

    @Override
    public void cacheObject(String chargingrule, String jsonString) {
        redisTemplate.opsForValue().set(chargingrule, jsonString);
        log.info("车位默认数量已读取，正在写入缓存中!");
    }

    @Override
    public Object getkey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 车位的减少，采用redis的原子操作,直接增减
     */
    @Override
    public void decrease(String currentaviablestallamt) {
        redisTemplate.opsForValue().decrement(currentaviablestallamt);
    }

    /**
     * 车位的增加，采用redis的原子操作,直接增减
     */
    @Override
    public void increase(String currentaviablestallamt) {
        redisTemplate.opsForValue().increment(currentaviablestallamt);
    }
}
