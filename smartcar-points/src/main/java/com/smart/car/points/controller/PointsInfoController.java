package com.smart.car.points.controller;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.points.entity.PointsExchange;
import com.smart.car.points.entity.PointsInfo;
import com.smart.car.points.service.PointsExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-15
 */
@RestController
@RequestMapping("points")
@AllArgsConstructor
public class PointsInfoController {

    private final PointsExchangeService pointsExchangeService;

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
        return ResponseResult.ok(userPoint,"远程调用结果,来自于：");
    }

    @PostMapping("/create")
    public ResponseResult create(String json) {
        pointsExchangeService.createExchange(json);
        return ResponseResult.ok();
    }
}
