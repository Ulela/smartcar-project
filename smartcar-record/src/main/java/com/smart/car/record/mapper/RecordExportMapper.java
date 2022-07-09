package com.smart.car.record.mapper;

import com.smart.car.record.entity.RecordExport;
import com.smart.car.record.entity.RecordExportExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordExportMapper {
    long countByExample(RecordExportExample example);

    int deleteByExample(RecordExportExample example);

    int deleteByPrimaryKey(String id);

    int insert(RecordExport record);

    int insertSelective(RecordExport record);

    List<RecordExport> selectByExample(RecordExportExample example);

    RecordExport selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecordExport record, @Param("example") RecordExportExample example);

    int updateByExample(@Param("record") RecordExport record, @Param("example") RecordExportExample example);

    int updateByPrimaryKeySelective(RecordExport record);

    int updateByPrimaryKey(RecordExport record);
}