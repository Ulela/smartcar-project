package com.smart.car.resource.mapper;

import com.smart.car.resource.entity.ResourceStallPark;
import com.smart.car.resource.entity.ResourceStallParkExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ResourceStallParkMapper {
    long countByExample(ResourceStallParkExample example);

    int deleteByExample(ResourceStallParkExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResourceStallPark record);

    int insertSelective(ResourceStallPark record);

    List<ResourceStallPark> selectByExample(ResourceStallParkExample example);

    ResourceStallPark selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResourceStallPark record, @Param("example") ResourceStallParkExample example);

    int updateByExample(@Param("record") ResourceStallPark record, @Param("example") ResourceStallParkExample example);

    int updateByPrimaryKeySelective(ResourceStallPark record);

    int updateByPrimaryKey(ResourceStallPark record);
}