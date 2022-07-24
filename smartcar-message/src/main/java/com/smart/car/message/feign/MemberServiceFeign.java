package com.smart.car.message.feign;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.message.entity.MemberUser;
import com.smart.car.message.feign.fallback.MemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程调用会员服务
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@FeignClient(value = "smartcar-member", fallback = MemberServiceFallback.class)
public interface MemberServiceFeign {

    @PostMapping(value = "/member/listFeign")
    public String listFeign();

    @PostMapping(value = "/member/getMember")
    public ResponseResult<MemberUser> getMemberInfo(@RequestParam(value = "memberId") String memberId);
}
