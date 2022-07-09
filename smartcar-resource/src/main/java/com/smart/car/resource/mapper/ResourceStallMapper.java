package com.smart.car.resource.mapper;

import com.smart.car.resource.entity.ResourceStall;
import com.smart.car.resource.entity.ResourceStallExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ResourceStallMapper {
    long countByExample(ResourceStallExample example);

    int deleteByExample(ResourceStallExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResourceStall record);

    int insertSelective(ResourceStall record);

    List<ResourceStall> selectByExample(ResourceStallExample example);

    ResourceStall selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResourceStall record, @Param("example") ResourceStallExample example);

    int updateByExample(@Param("record") ResourceStall record, @Param("example") ResourceStallExample example);

    int updateByPrimaryKeySelective(ResourceStall record);

    int updateByPrimaryKey(ResourceStall record);
}