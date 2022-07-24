package com.smart.car.resource.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.resource.entity.ResourceStall;
import com.smart.car.resource.entity.ResourceStallExample;
import com.smart.car.resource.entity.ResourceStallPark;
import com.smart.car.resource.mapper.ResourceStallMapper;
import com.smart.car.resource.mapper.ResourceStallParkMapper;
import com.smart.car.resource.service.RedisService;
import com.smart.car.resource.service.ResourceStallService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资源车位记录实现
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@Service
@AllArgsConstructor
public class ResourceStallServiceImpl implements ResourceStallService {

    private final ResourceStallMapper stallMapper;

    private final ResourceStallParkMapper stallPardedMapper;

    private final RedisService redisService;

    /**
     * 空闲车位更新记录
     */
    @Override
    @Transactional
    public int occupy(String json) {
        ResourceStallPark stallParked = JSONObject.parseObject(json, ResourceStallPark.class);
        log.info("车位停放的数据= " + json);
        // 此处没有将可用车位信息刷新，而是提前在车辆入场时更新可用车位数据，是避免车辆进来了无位可停的情况
        ResourceStallExample example = new ResourceStallExample();
        example.createCriteria().andIdEqualTo(stallParked.getStallId());
        ResourceStall updateStall = new ResourceStall();
        updateStall.setId(stallParked.getStallId());
        updateStall.setIsParked(1);
        stallMapper.updateByExampleSelective(updateStall, example);
        log.info(" 停放车位 = " + json);
        return stallPardedMapper.insertSelective(stallParked);
    }

    @Override
    @Transactional
    public int exist(String json) {
        ResourceStallPark stallParked = JSONObject.parseObject(json, ResourceStallPark.class);
        log.info("车位是否还被占用？ " + json);
        // update stall unparked status
        ResourceStallExample example = new ResourceStallExample();
        example.createCriteria().andIdEqualTo(stallParked.getStallId());
        ResourceStall updateStall = new ResourceStall();
        updateStall.setId(stallParked.getStallId());
        updateStall.setIsParked(0);
        stallMapper.updateByExampleSelective(updateStall, example);
        log.info("释放车位 = " + json);
        //离开后就将可用车位释放，提交将可用车位数据更新，提高车位的使用效率
        redisService.increase("currentAviableStallAmt");
        return stallPardedMapper.updateByPrimaryKey(stallParked);
    }

    @Override
    public List<ResourceStall> list(String json) {
        ResourceStallExample example = new ResourceStallExample();
        List<ResourceStall> list = stallMapper.selectByExample(example);
        return list;
    }
}