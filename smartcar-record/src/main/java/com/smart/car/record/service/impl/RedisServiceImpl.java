package com.smart.car.record.service.impl;

import com.smart.car.record.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 对计费规则的原子操作
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@Service
@AllArgsConstructor
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, Serializable> redisTemplate;

    /**
     * 判断缓存key是否存在
     * @param chargingrule
     * @return falsh过期  true未过期
     */
    @Override
    public boolean exist(String chargingrule) {
        ValueOperations<String, Serializable> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(chargingrule) != null ? true : false;
    }

    /**
     * 添加 key:string 缓存
     */
    @Override
    public void cacheObject(String chargingrule, String jsonString) {
        redisTemplate.opsForValue().set(chargingrule, jsonString);
        log.info("将收费规则缓存进redis中!");
    }

    @Override
    public Object getkey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void decrease(String currentaviablestallamt) {
        redisTemplate.opsForValue().decrement(currentaviablestallamt);
    }

    @Override
    public void increase(String currentaviablestallamt) {
        redisTemplate.opsForValue().increment(currentaviablestallamt);
    }
}
