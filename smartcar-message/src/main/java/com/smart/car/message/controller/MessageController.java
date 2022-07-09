package com.smart.car.message.controller;

import com.smart.car.message.entity.MessageInfo;
import com.smart.car.message.service.MessageInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/list")
    public List<MessageInfo> list() {
        List<MessageInfo> messages= messageInfoService.list();
        log.info("查询到的message信息是：{} ", messages);
        return messages;
    }
}



