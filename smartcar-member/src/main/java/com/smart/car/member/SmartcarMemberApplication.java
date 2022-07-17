package com.smart.car.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmartcarMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartcarMemberApplication.class, args);
    }

}
