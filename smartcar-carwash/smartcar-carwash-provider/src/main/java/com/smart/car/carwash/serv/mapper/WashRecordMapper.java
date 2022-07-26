package com.smart.car.carwash.serv.mapper;

import com.smart.car.carwash.api.entity.WashRecord;
import com.smart.car.carwash.serv.entity.WashRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WashRecordMapper {
    long countByExample(WashRecordExample example);

    int deleteByExample(WashRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(WashRecord record);

    int insertSelective(WashRecord record);

    List<WashRecord> selectByExample(WashRecordExample example);

    WashRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WashRecord record, @Param("example") WashRecordExample example);

    int updateByExample(@Param("record") WashRecord record, @Param("example") WashRecordExample example);

    int updateByPrimaryKeySelective(WashRecord record);

    int updateByPrimaryKey(WashRecord record);
}