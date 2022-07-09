package com.smart.car.record.mapper;

import com.smart.car.record.entity.RecordEntrance;
import com.smart.car.record.entity.RecordEntranceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordEntranceMapper {
    long countByExample(RecordEntranceExample example);

    int deleteByExample(RecordEntranceExample example);

    int deleteByPrimaryKey(String id);

    int insert(RecordEntrance record);

    int insertSelective(RecordEntrance record);

    List<RecordEntrance> selectByExample(RecordEntranceExample example);

    RecordEntrance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecordEntrance record, @Param("example") RecordEntranceExample example);

    int updateByExample(@Param("record") RecordEntrance record, @Param("example") RecordEntranceExample example);

    int updateByPrimaryKeySelective(RecordEntrance record);

    int updateByPrimaryKey(RecordEntrance record);
}