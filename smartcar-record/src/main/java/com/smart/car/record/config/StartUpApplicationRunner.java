package com.smart.car.record.config;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.common.res.constant.Constants;
import com.smart.car.record.entity.RecordChargeRule;
import com.smart.car.record.service.RecordChargeRuleService;
import com.smart.car.record.service.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Component
@Order(value = 1)
@AllArgsConstructor
public class StartUpApplicationRunner implements ApplicationRunner {

    private final RedisService redisService;

    private RecordChargeRuleService chargeRuleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //查询db中的计费规则
        List<RecordChargeRule> rules = chargeRuleService.list();
        //redis中是否已存在？
        if (!redisService.exist("CHARGINGRULE")) {
            redisService.cacheObject("CHARGINGRULE", JSONObject.toJSONString(rules));
        }
    }
}
