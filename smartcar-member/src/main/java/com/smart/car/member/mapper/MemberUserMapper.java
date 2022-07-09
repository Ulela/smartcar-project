package com.smart.car.member.mapper;

import com.smart.car.member.entity.MemberUser;
import com.smart.car.member.entity.MemberUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MemberUserMapper {
    long countByExample(MemberUserExample example);

    int deleteByExample(MemberUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(MemberUser record);

    int insertSelective(MemberUser record);

    List<MemberUser> selectByExample(MemberUserExample example);

    MemberUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MemberUser record, @Param("example") MemberUserExample example);

    int updateByExample(@Param("record") MemberUser record, @Param("example") MemberUserExample example);

    int updateByPrimaryKeySelective(MemberUser record);

    int updateByPrimaryKey(MemberUser record);
}