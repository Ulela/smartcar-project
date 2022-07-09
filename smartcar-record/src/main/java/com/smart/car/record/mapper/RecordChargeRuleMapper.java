package com.smart.car.record.mapper;

import com.smart.car.record.entity.RecordChargeRule;
import com.smart.car.record.entity.RecordChargeRuleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordChargeRuleMapper {
    long countByExample(RecordChargeRuleExample example);

    int deleteByExample(RecordChargeRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(RecordChargeRule record);

    int insertSelective(RecordChargeRule record);

    List<RecordChargeRule> selectByExample(RecordChargeRuleExample example);

    RecordChargeRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecordChargeRule record, @Param("example") RecordChargeRuleExample example);

    int updateByExample(@Param("record") RecordChargeRule record, @Param("example") RecordChargeRuleExample example);

    int updateByPrimaryKeySelective(RecordChargeRule record);

    int updateByPrimaryKey(RecordChargeRule record);
}