package com.smart.car.message.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenf
 * @version 1.0
 */
@RestController
public class MessageController {

    @RequestMapping("/list")
    public String test() {
        return "hello-world-江湖一点雨";
    }
}

