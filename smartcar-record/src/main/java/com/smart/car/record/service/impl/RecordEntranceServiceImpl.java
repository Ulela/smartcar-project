package com.smart.car.record.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.record.entity.RecordEntrance;
import com.smart.car.record.entity.RecordEntranceExample;
import com.smart.car.record.mapper.RecordEntranceMapper;
import com.smart.car.record.service.RecordEntranceService;
import com.smart.car.record.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 车辆入场记录实现
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@Service
@AllArgsConstructor
public class RecordEntranceServiceImpl implements RecordEntranceService {
    private final RecordEntranceMapper entranceMapper;
    private final RedisService redisService;

    @Override
    public List<RecordEntrance> list() {
        RecordEntranceExample example = new RecordEntranceExample();
        List<RecordEntrance> infoList = entranceMapper.selectByExample(example);
        return infoList;
    }

    //事务性，刷新景区可用车位数
    @Transactional
    @Override
    public int createEntrance(String json) throws BusinessException {
        log.info("创建入场车位数量= " + json);
        RecordEntrance entrance = JSONObject.parseObject(json, RecordEntrance.class);
        //减少可用的停车数量
        redisService.decrease("currentAviableStallAmt");
        log.info("减少可用的数量 = " + json);
        return entranceMapper.insertSelective(entrance);
    }
}
