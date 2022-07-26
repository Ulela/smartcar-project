package com.smart.car.carwash.serv.impl;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.carwash.api.entity.WashRecord;
import com.smart.car.carwash.api.service.CarWashProviderService;
import com.smart.car.carwash.serv.mapper.WashRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-25
 */
/**
 * dubbo 业务实现类
 */
@Slf4j
@Service(protocol = "dubbo")
public class CarWashServiceImpl implements CarWashProviderService {

    @Autowired
    private WashRecordMapper carWashMapper;

    @Override
    public int wash(String json) {
        WashRecord carWash = JSONObject.parseObject(json, WashRecord.class);
        int rtn = carWashMapper.insertSelective(carWash);
        log.info("洗车数据新增成功>>>>>>>>>>>>>>> " + json);
        return rtn;
    }

    @Override
    public int sendNotice(String json) {
        return 0;
    }

    @Override
    public List<WashRecord> list() {
        return null;
    }
}
