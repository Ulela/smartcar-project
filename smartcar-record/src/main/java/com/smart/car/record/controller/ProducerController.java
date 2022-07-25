package com.smart.car.record.controller;

import com.alibaba.fastjson.JSONObject;
import com.smart.car.common.res.bean.MessageInfo;
import com.smart.car.common.res.bean.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Producer(MQ的生产者类)测试
 * @author chenf
 * @version 1.0
 * @date 2022-07-25
 */
@Slf4j
@RestController
@RequestMapping("mq")
public class ProducerController {

    @Autowired
    private Source source;

    //RocketMQ 发送消息（创建消息）测试
    @PostMapping("/sendTestMsg")
    public ResponseResult sendTestMsg() {
        // 构建消息对象
        MessageInfo message = new MessageInfo()
                .setMcontent("这是一条来自生产者的测试消息！")
                .setMtype("支付信息");
        this.source.output().send(MessageBuilder.withPayload(JSONObject.toJSONString(message)).build());
        log.info("发送消息成功..." + message);
        return ResponseResult.ok(message,"消息发送成功！");
    }
}
