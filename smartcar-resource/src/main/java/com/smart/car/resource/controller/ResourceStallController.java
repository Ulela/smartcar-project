package com.smart.car.resource.controller;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.resource.entity.ResourceStall;
import com.smart.car.resource.service.RedisService;
import com.smart.car.resource.service.ResourceStallService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Api(tags = "车位资源模块")
@Slf4j
@RestController
@RequestMapping("stall")
@AllArgsConstructor
public class ResourceStallController {

    private final ResourceStallService stallService;

    @PostMapping("/list")
    public ResponseResult<List<ResourceStall>> list(String json) throws BusinessException {
        ResponseResult<List<ResourceStall>> commonResult = new ResponseResult<>();
        List<ResourceStall> rtn = stallService.list(json);
        commonResult.setData(rtn);
        return commonResult;
    }

    /**
     * TODO 被使用的车位
     */
    @PostMapping("/occupy")
    public ResponseResult<Integer> occupy(String json) throws BusinessException {
        ResponseResult<Integer> commonResult = new ResponseResult<>();
        int rtn = stallService.occupy(json);
        commonResult.setData(rtn);
        return commonResult;
    }

    /**
     * TODO 车位是否还被占用？
     *
     */
    @PostMapping("/exist")
    public ResponseResult<Integer> exist(String json) throws BusinessException {
        ResponseResult<Integer> commonResult = new ResponseResult<>();
        int rtn = stallService.exist(json);
        commonResult.setData(rtn);
        return commonResult;
    }

    private final RedisService redisService;
    /**
     * TODO 当前可用的停车券
     */
    @PostMapping("/currentAviableStallAmt")
    public ResponseResult<Integer> get() throws BusinessException {
        ResponseResult<Integer> commonResult = new ResponseResult<>();
        Object rtn = redisService.getkey("currentAviableStallAmt");
        commonResult.setData(Integer.valueOf(rtn + ""));
        return commonResult;
    }
}
