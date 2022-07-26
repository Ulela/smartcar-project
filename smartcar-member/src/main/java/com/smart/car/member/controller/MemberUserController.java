package com.smart.car.member.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.smart.car.carwash.api.service.CarWashProviderService;
import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.member.entity.MemberUser;
import com.smart.car.member.feign.PointsFeignService;
import com.smart.car.member.feign.fallback.MemberBlockHandler;
import com.smart.car.member.feign.fallback.MemberFallBackHandler;
import com.smart.car.member.service.MemberUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-09
 */
@Slf4j
@Api(tags = "用户模块")
@RestController
@RequestMapping("member")
@RefreshScope
public class MemberUserController {

//    @Value("${author.nickname:jack}")
//    private String nickname;
//
//    @Value("${server.port:9999}")
//    private String port;

    @Autowired
    private  MemberUserService memberUserService;
    @Autowired
    private  PointsFeignService pointsFeignService;
    @Reference
    private  CarWashProviderService washService;

//    @GetMapping("/read-local-config")
//    @ApiOperation(value = "配置文件读取测试")
//    public ResponseResult testLocalConfig() {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("appName", nickname);
//        map.put("port", port);
//        return ResponseResult.ok(map);
//    }

    /**
     * TODO 查询所有用户信息
     * TODO 搭配sentinel限流熔断或异常快速失败。采用fallback或BackHandler指定
     * @author zoutao.blog.csdn.net
     */
    @SentinelResource(value = "list")
    @ApiOperation(value = "限流案例-查询所有用户信息")
    @GetMapping("user/list")
    public ResponseResult<String> list() {
        List<MemberUser> members = memberUserService.list();
        log.info("本地查询用户列表：{} " ,members);
        //int a = 1 / 0;
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setMsg("查询成功");
        result.setData(members);
        return result;
    }

    @GetMapping("user/{id}")
    public ResponseResult<MemberUser> getUser(@PathVariable("id") String id) {
        return ResponseResult.ok(memberUserService.queryById(id));
    }

    /**
     * 通过用户id获取用户积分信息
     * @author zoutao.blog.csdn.net
     */
    @GetMapping("/mypoint/{id}")
    @SentinelResource(value = "mypoint/{id}",
            blockHandler = "blackException",blockHandlerClass = MemberBlockHandler.class,
            fallback = "memberFallBack",fallbackClass = MemberFallBackHandler.class)
    @ApiOperation(value = "通过用户id获取用户积分信息")
    public ResponseResult getUserPointsTest(@PathVariable("id") String id) {
        log.info("开始远程调用，去获取该用户的积分信息：{} ",id);
        ResponseResult result = pointsFeignService.getUserPoints(id);
        return result;
    }

//    @GetMapping("/user/list")
//    @ApiOperation(value = "查询所有用户信息")
//    public List<MemberUser> list() {
//        List<MemberUser> members = memberUserService.list();
//        log.info("查询用户列表：{} " ,members);
//        return members;
//    }

    @ApiOperation(value = "测试用户")
    @PostMapping("/checkAddUser")
    public String addUser_Validator(@RequestBody @Valid MemberUser user) {
        List<MemberUser> users = memberUserService.queryUser(user.getPhone());
        return users.toString();
    }

    /**
     * TODO Dubbo 调用示例--洗车服务
     * TODO {"plateNum":"粤AG9527","couponCode":"Ts0999"}
     * @param json
     * @return result
     */
    @PostMapping("/wash")
    public ResponseResult<Integer> wash(@RequestBody String json) throws BusinessException {
        log.debug("洗车服务 = " + json);
        ResponseResult<Integer> result = new ResponseResult<>();
        int rtn = washService.wash(json);
        result.setCode(200);
        result.setMsg("dubbo调用，洗车业务开展成功");
        result.setData(rtn);
        return result;
    }

}


