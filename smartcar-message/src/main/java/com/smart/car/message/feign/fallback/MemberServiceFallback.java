package com.smart.car.message.feign.fallback;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.message.entity.MemberUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 快速回退方案
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@Component
public class MemberServiceFallback {

    @PostMapping(value = "/member/listFeign")
    public String listFeign(){
        String result = null;
        log.warn("member服务 listFeign 方法不可用！ ");
        return result;
    }

    @PostMapping(value = "/member/getMember")
    public ResponseResult<MemberUser> getMemberInfo(@RequestParam(value = "memberId") String memberId){
        ResponseResult<MemberUser> result = new ResponseResult<>();
        result.setMsg("member服务 getMemberInfo 方法 不可用!");
        log.warn("member服务 getMemberInfo 方法 不可用!");
        result.setData(null);
        return result;
    }
}
