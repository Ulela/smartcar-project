package com.smart.car.message.controller;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.message.entity.MessageInfo;
import com.smart.car.message.service.MessageInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("message")
@AllArgsConstructor
public class MessageController {
    private final MessageInfoService messageInfoService;

    @GetMapping("/test")
    public String test() {
        log.info("hello-江湖一点雨");
        return "hello-world-江湖一点雨";
    }

    /**
     *  查询历史消息记录
     */
    @GetMapping("/list")
    public List<MessageInfo> list() {
        List<MessageInfo> messages = messageInfoService.list();
        log.debug("查询历史消息记录： " + messages);
        return messages;
    }

    /**
     * 记录发送过的消息通知
     */
    @PostMapping("/sendNotice")
    public ResponseResult<Integer> sendNotice(@RequestParam("json") String json) throws BusinessException {
        log.info("获取到的消息msg：" + json);
        ResponseResult<Integer> commonResult = new ResponseResult<>();
        int rtn = messageInfoService.sendNotice(json);
        commonResult.setData(rtn);
        return commonResult;
    }
}



