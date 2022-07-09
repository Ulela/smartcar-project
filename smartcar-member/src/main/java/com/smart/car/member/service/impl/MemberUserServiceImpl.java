package com.smart.car.member.service.impl;

import com.smart.car.member.entity.MemberUser;
import com.smart.car.member.entity.MemberUserExample;
import com.smart.car.member.mapper.MemberUserMapper;
import com.smart.car.member.service.MemberUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-09
 */
@Service
@AllArgsConstructor
public class MemberUserServiceImpl implements MemberUserService {
    private final MemberUserMapper memberUserMapper;
    @Override
    public List<MemberUser> list() {
        return memberUserMapper.selectByExample(new MemberUserExample());
    }

    @Override
    public List<MemberUser> queryUser(String phone) {
        MemberUserExample userExample = new MemberUserExample();
        MemberUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        return memberUserMapper.selectByExample(userExample);
    }
}
