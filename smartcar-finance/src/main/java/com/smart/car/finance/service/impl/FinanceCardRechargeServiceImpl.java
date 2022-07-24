package com.smart.car.finance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.finance.entity.FinanceCardRecharge;
import com.smart.car.finance.mapper.FinanceCardRechargeMapper;
import com.smart.car.finance.service.FinanceCardRechargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Service
@Slf4j
public class FinanceCardRechargeServiceImpl implements FinanceCardRechargeService {

    @Resource
    private FinanceCardRechargeMapper rechargeMapper;

    @Override
    public int create(String json) {
        FinanceCardRecharge recharge = JSONObject.parseObject(json, FinanceCardRecharge.class);
        log.info(" 记录充值数据= " + json);
        return rechargeMapper.insertSelective(recharge);
    }
}
