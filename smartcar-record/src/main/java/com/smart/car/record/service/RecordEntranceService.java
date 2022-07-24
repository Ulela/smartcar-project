package com.smart.car.record.service;

import com.smart.car.record.entity.RecordEntrance;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
public interface RecordEntranceService {
    List<RecordEntrance> list();

    int createEntrance(String json);
}
