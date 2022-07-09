package com.smart.car.member.controller;

import com.smart.car.member.entity.MemberUser;
import com.smart.car.member.service.MemberUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@AllArgsConstructor
public class MemberUserController {

    private final MemberUserService memberUserService;

    @GetMapping("/user/list")
    @ApiOperation(value = "查询所有用户信息")
    public List<MemberUser> list() {
        List<MemberUser> members = memberUserService.list();
        log.info("查询用户列表：{} " ,members);
        return members;
    }

    @ApiOperation(value = "测试用户")
    @PostMapping("/checkAddUser")
    public String addUser_Validator(@RequestBody @Validated MemberUser user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            for (ObjectError error : bindingResult.getAllErrors()) {
                return error.getDefaultMessage();
            }
        }
        List<MemberUser> users = memberUserService.queryUser(user.getPhone());
        return users.toString();
    }
}


