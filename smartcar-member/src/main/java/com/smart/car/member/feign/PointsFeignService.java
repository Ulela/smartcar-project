package com.smart.car.member.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.member.feign.fallback.MemberBlockHandler;
import com.smart.car.member.feign.fallback.MemberFallBackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-15
 */
//@FeignClient(value = "smartcar-points")
@FeignClient(value = "smartcar-points")
public interface PointsFeignService {

    @GetMapping("points/info/{id}")
    public ResponseResult getUserPoints(@PathVariable("id")String id);

}
