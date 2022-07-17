package com.smart.car.member.service;

import com.smart.car.member.entity.MemberUser;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-09
 */
public interface MemberUserService {
    List<MemberUser> list();

    List<MemberUser> queryUser(String phone);

    MemberUser queryById(String id);
}
