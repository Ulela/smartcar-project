package com.smart.car.points.controller;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.points.entity.PointsInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-15
 */
@RestController
@RequestMapping("points")
public class PointsInfoController {

    //SPEL表达式
    @Value("${server.port}")
    private String port;

    /**
     * TODO 远程调用实例
     *
     * @author zoutao.blog.csdn.net
     */
    @GetMapping("/info/{id}")
    public ResponseResult<PointsInfo> getUserPoints(@PathVariable("id") String id) {
        PointsInfo userPoint = new PointsInfo();
        userPoint.setMemberId(id);
        userPoint.setCurQty("100");
        userPoint.setCreateBy("江湖一点雨");
        return ResponseResult.ok(userPoint,"远程调用结果,来自于："+port);
    }
}
