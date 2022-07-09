package com.smart.car.member.mapper;

import com.smart.car.member.entity.MemberVehicle;
import com.smart.car.member.entity.MemberVehicleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MemberVehicleMapper {
    long countByExample(MemberVehicleExample example);

    int deleteByExample(MemberVehicleExample example);

    int deleteByPrimaryKey(String id);

    int insert(MemberVehicle record);

    int insertSelective(MemberVehicle record);

    List<MemberVehicle> selectByExample(MemberVehicleExample example);

    MemberVehicle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MemberVehicle record, @Param("example") MemberVehicleExample example);

    int updateByExample(@Param("record") MemberVehicle record, @Param("example") MemberVehicleExample example);

    int updateByPrimaryKeySelective(MemberVehicle record);

    int updateByPrimaryKey(MemberVehicle record);
}