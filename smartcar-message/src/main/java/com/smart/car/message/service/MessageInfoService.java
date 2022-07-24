package com.smart.car.message.service;

import com.smart.car.message.entity.MessageInfo;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-09
 */
public interface MessageInfoService {
    int sendNotice(String json);
    List<MessageInfo> list();
}

