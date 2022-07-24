package com.smart.car.points.config;

import com.smart.car.common.res.constant.Constants;
import lombok.AllArgsConstructor;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 初始化类
 * 优惠券可兑换数量
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Order(0)
@Component
@AllArgsConstructor
public class StartupApplicatonRunner implements ApplicationRunner {

    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RAtomicLong atomicLong = redissonClient.getAtomicLong(Constants.cache.grouponCodeAmtKey);
        atomicLong.set(Constants.cache.grouponCodeAmt);
    }
}
