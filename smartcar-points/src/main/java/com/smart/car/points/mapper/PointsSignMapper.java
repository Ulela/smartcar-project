package com.smart.car.points.mapper;

import com.smart.car.points.entity.PointsSign;
import com.smart.car.points.entity.PointsSignExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PointsSignMapper {
    long countByExample(PointsSignExample example);

    int deleteByExample(PointsSignExample example);

    int deleteByPrimaryKey(String id);

    int insert(PointsSign record);

    int insertSelective(PointsSign record);

    List<PointsSign> selectByExample(PointsSignExample example);

    PointsSign selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PointsSign record, @Param("example") PointsSignExample example);

    int updateByExample(@Param("record") PointsSign record, @Param("example") PointsSignExample example);

    int updateByPrimaryKeySelective(PointsSign record);

    int updateByPrimaryKey(PointsSign record);
}