package com.smart.car.record.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.smart.car.common.res.constant.Constants;
import com.smart.car.record.entity.RecordChargeRule;
import com.smart.car.record.entity.RecordChargeRuleExample;
import com.smart.car.record.mapper.RecordChargeRuleMapper;
import com.smart.car.record.service.RedisService;
import com.smart.car.record.service.RuleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Service
@AllArgsConstructor
@Slf4j
public class RuleServiceImpl implements RuleService {

    private final RecordChargeRuleMapper recordChargeRuleMapper;
    private final RedisService redisService;

    @Override
    public List<RecordChargeRule> list() {
        return recordChargeRuleMapper.selectByExample(new RecordChargeRuleExample());
    }

    //刷新缓存
    @Override
    public int refresh() {
        RecordChargeRuleExample example = new RecordChargeRuleExample();
        example.setOrderByClause("start asc");
        List<RecordChargeRule> list = recordChargeRuleMapper.selectByExample(example);
        if (ObjectUtil.isNotEmpty(list)) {
            redisService.cacheObject("ruleList", JSONObject.toJSONString(list));
            log.info("刷新计费规则到Redis缓存!");
        }
        return Constants.SUCCESS;
    }
}
