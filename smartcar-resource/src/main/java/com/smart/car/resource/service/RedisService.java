package com.smart.car.resource.service;

import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
public interface RedisService {
    public boolean exist(String chargingrule);

    public void cacheObject(String chargingrule, String jsonString);

    public Object getkey(String key);

    /**
     * 车位的减少，采用redis的原子操作,直接增减
     */
    public void decrease(String currentaviablestallamt);
    /**
     * 车位的增加，采用redis的原子操作,直接增减
     */
    public void increase(String currentaviablestallamt);
}
