package com.smart.car.member.feign.fallback;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.member.feign.PointsFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 默认快速失败方案，类模式。
 * @author chenf
 * @version 1.0
 * @date 2022-07-16
 */
//@Slf4j
//@Component
//public class PointsServiceFallback implements PointsFeignService {
//    // 出错则调用该方法快速响应
//    @Override
//    public ResponseResult<Void> getUserPoints(String id) {
//        ResponseResult result = new ResponseResult<Void>();
//        result.setMsg("服务不可用，开始熔断，启动降级快速响应!（您操作太频繁了，请稍后再试~）");
//        result.setCode(500);
//        log.warn(result.toString());
//        return result;
//    }
//}
