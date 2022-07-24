package com.smart.car.points.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.common.res.constant.Constants;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.points.entity.PointsExchange;
import com.smart.car.points.mapper.PointsExchangeMapper;
import com.smart.car.points.service.PointsExchangeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 优惠券兑换逻辑
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Service
@Slf4j
@AllArgsConstructor
public class PointsExchangeServiceImpl implements PointsExchangeService {

    private final PointsExchangeMapper exchangeMapper;

    private final RedissonClient redissonClient;

    @Override
    public int createExchange(String json) throws BusinessException {
        PointsExchange exchange = JSONObject.parseObject(json, PointsExchange.class);
        int rtn = 0;
        // 兑换类型有两部分，0是商场优惠券，1是洗车券（如果是优惠券，则使用redisson进行处理）
        if (exchange.getCtype() == 0) {
            RAtomicLong atomicLong = redissonClient.getAtomicLong(Constants.cache.grouponCodeAmtKey);
            // 获得锁
            RLock rLock = redissonClient.getLock(Constants.lock.exchangeCouponLock);
            // 锁定，默认10s不主动解锁的话，自动解锁，防止出现死锁的情况。正常情况下可基于redisson获取redLock处理，更加安全，本测试基于单机redis测试。
            rLock.lock(1000, TimeUnit.SECONDS);
            log.info("释放时将其锁定 ...");
            // 当优惠券数量> 0时，才可兑换，兑换结束数量减一
            if (atomicLong.get() > 0) {
                rtn = exchangeMapper.insertSelective(exchange);
                atomicLong.decrementAndGet();
            }
            // 释放锁
            rLock.unlock();
            log.info("兑换优惠券结束...");
        } else {
            rtn = exchangeMapper.insertSelective(exchange);
        }
        log.debug("兑换成功了= " + exchange.getId());
        return rtn;
    }
}
