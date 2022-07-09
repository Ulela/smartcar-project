package com.smart.car.resource.mapper;

import com.smart.car.resource.entity.ResourceBrake;
import com.smart.car.resource.entity.ResourceBrakeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResourceBrakeMapper {
    long countByExample(ResourceBrakeExample example);

    int deleteByExample(ResourceBrakeExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResourceBrake record);

    int insertSelective(ResourceBrake record);

    List<ResourceBrake> selectByExample(ResourceBrakeExample example);

    ResourceBrake selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResourceBrake record, @Param("example") ResourceBrakeExample example);

    int updateByExample(@Param("record") ResourceBrake record, @Param("example") ResourceBrakeExample example);

    int updateByPrimaryKeySelective(ResourceBrake record);

    int updateByPrimaryKey(ResourceBrake record);
}