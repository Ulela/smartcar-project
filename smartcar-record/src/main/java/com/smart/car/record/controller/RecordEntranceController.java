package com.smart.car.record.controller;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.record.entity.RecordEntrance;
import com.smart.car.record.service.RecordEntranceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 车辆入库记录控制
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@RestController
@RequestMapping("entrance")
@AllArgsConstructor
public class RecordEntranceController {

    private final RecordEntranceService entranceService;

    @GetMapping("/test")
    public String test() {
        log.info("hello-江湖一点雨");
        return "hello-world-江湖一点雨";
    }

    @GetMapping("/list")
    public List<RecordEntrance> list() {
        List<RecordEntrance> messages = entranceService.list();
        return messages;
    }

    /**
     *  新增记录
     */
    @PostMapping("/create")
    public ResponseResult<Integer> create(String json) throws BusinessException {
        ResponseResult<Integer> result = new ResponseResult<>();
        int rtn = entranceService.createEntrance(json);
        result.setData(rtn);
        return result;
    }
}
