package com.smart.car.record.service;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
public interface RedisService {
    boolean exist(String chargingrule);
    void cacheObject(String chargingrule, String jsonString);
    Object getkey(String key);
    void decrease(String currentaviablestallamt);
    void increase(String currentaviablestallamt);
}
