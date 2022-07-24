package com.smart.car.resource.service;

import com.smart.car.resource.entity.ResourceStall;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
public interface ResourceStallService {
    int occupy(String json);
    int exist(String json);
    List<ResourceStall> list(String json);
}
