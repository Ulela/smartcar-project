package com.smart.car.message.service.impl;

import com.smart.car.message.entity.MessageInfo;
import com.smart.car.message.entity.MessageInfoExample;
import com.smart.car.message.mapper.MessageInfoMapper;
import com.smart.car.message.service.MessageInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-09
 */
@Service
@AllArgsConstructor
public class MessageServiceInfoImpl implements MessageInfoService {
    private final MessageInfoMapper messageMapper;

    @Override
    public List<MessageInfo> list() {
        MessageInfoExample example = new MessageInfoExample();
        return messageMapper.selectByExample(example);
    }
}

