package com.smart.car.points.mapper;

import com.smart.car.points.entity.PointsExchange;
import com.smart.car.points.entity.PointsExchangeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointsExchangeMapper {
    long countByExample(PointsExchangeExample example);

    int deleteByExample(PointsExchangeExample example);

    int deleteByPrimaryKey(String id);

    int insert(PointsExchange record);

    int insertSelective(PointsExchange record);

    List<PointsExchange> selectByExample(PointsExchangeExample example);

    PointsExchange selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PointsExchange record, @Param("example") PointsExchangeExample example);

    int updateByExample(@Param("record") PointsExchange record, @Param("example") PointsExchangeExample example);

    int updateByPrimaryKeySelective(PointsExchange record);

    int updateByPrimaryKey(PointsExchange record);
}