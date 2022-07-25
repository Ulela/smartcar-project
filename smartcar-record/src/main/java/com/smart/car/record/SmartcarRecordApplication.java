package com.smart.car.record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding(Source.class)  //采用自定义的收发消息接口
public class SmartcarRecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartcarRecordApplication.class, args);
    }

}
