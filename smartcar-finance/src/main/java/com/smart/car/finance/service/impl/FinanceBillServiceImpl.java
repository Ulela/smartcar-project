package com.smart.car.finance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.finance.entity.FinanceBill;
import com.smart.car.finance.entity.FinanceBillExample;
import com.smart.car.finance.mapper.FinanceBillMapper;
import com.smart.car.finance.service.FinanceBillService;
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
public class FinanceBillServiceImpl implements FinanceBillService {

    private final FinanceBillMapper billMapper;

    @Override
    public int create(String json) {
        FinanceBill bill = JSONObject.parseObject(json, FinanceBill.class);
        log.info("分析帐单数据，存入支付记录表中>>>>>>>>>> " +json);
        return billMapper.insertSelective(bill);
    }
    @Override
    public List<FinanceBill> list() {
        FinanceBillExample example = new FinanceBillExample();
        return billMapper.selectByExample(example);
    }
}
