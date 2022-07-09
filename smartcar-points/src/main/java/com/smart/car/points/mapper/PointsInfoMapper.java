package com.smart.car.points.mapper;

import com.smart.car.points.entity.PointsInfo;
import com.smart.car.points.entity.PointsInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PointsInfoMapper {
    long countByExample(PointsInfoExample example);

    int deleteByExample(PointsInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(PointsInfo record);

    int insertSelective(PointsInfo record);

    List<PointsInfo> selectByExample(PointsInfoExample example);

    PointsInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PointsInfo record, @Param("example") PointsInfoExample example);

    int updateByExample(@Param("record") PointsInfo record, @Param("example") PointsInfoExample example);

    int updateByPrimaryKeySelective(PointsInfo record);

    int updateByPrimaryKey(PointsInfo record);
}