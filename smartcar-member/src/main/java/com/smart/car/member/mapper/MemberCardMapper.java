package com.smart.car.member.mapper;

import com.smart.car.member.entity.MemberCard;
import com.smart.car.member.entity.MemberCardExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberCardMapper {
    long countByExample(MemberCardExample example);

    int deleteByExample(MemberCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(MemberCard record);

    int insertSelective(MemberCard record);

    List<MemberCard> selectByExample(MemberCardExample example);

    MemberCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    int updateByExample(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    int updateByPrimaryKeySelective(MemberCard record);

    int updateByPrimaryKey(MemberCard record);
}