package com.smart.car.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.message.entity.MessageInfo;
import com.smart.car.message.entity.MessageInfoExample;
import com.smart.car.message.mapper.MessageInfoMapper;
import com.smart.car.message.service.MessageInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-09
 */
@Service
@Slf4j
@AllArgsConstructor
public class MessageServiceInfoImpl implements MessageInfoService {
    private final MessageInfoMapper messageMapper;

    @Override
    public List<MessageInfo> list() {
        MessageInfoExample example = new MessageInfoExample();
        List<MessageInfo> infoList = messageMapper.selectByExample(example);
        return infoList;
    }

    //记录发送的通知消息
    @Override
    public int sendNotice(String json) {
        log.info("message数据是 = " + json);
        MessageInfo message = JSONObject.parseObject(json, MessageInfo.class);
        return messageMapper.insertSelective(message);
    }
}

