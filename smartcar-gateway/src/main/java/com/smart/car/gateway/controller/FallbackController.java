package com.smart.car.gateway.controller;

import com.smart.car.common.res.bean.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-20
 */
@Slf4j
@RestController
@RequestMapping("error")
public class FallbackController {

    @RequestMapping("/fallback")
    public ResponseResult<String> fallback() {
        ResponseResult<String> result = new ResponseResult<>();
        log.error("Invoke service failed...");
        result.setCode(429);
        result.setMsg("对应的服务调用失败，快速熔断，进入fallback降级方法。");
        return result;
    }
}
