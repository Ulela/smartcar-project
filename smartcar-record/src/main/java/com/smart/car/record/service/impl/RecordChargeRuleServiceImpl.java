package com.smart.car.record.service.impl;


import com.smart.car.record.entity.RecordChargeRule;
import com.smart.car.record.entity.RecordChargeRuleExample;
import com.smart.car.record.mapper.RecordChargeRuleMapper;
import com.smart.car.record.service.RecordChargeRuleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@Service
@AllArgsConstructor
public class RecordChargeRuleServiceImpl implements RecordChargeRuleService {

    private final RecordChargeRuleMapper recordChargeRuleMapper;

    @Override
    public List<RecordChargeRule> list() {
        return recordChargeRuleMapper.selectByExample(new RecordChargeRuleExample());
    }
}
