package com.smart.car.carwash.api.service;

import com.smart.car.carwash.api.entity.WashRecord;

import java.util.List;

/**
 * dubbo-API服务提供者
 * @author chenf
 */
public interface CarWashProviderService {

    int wash(String json);

    int sendNotice(String json);

    List<WashRecord> list();
}
