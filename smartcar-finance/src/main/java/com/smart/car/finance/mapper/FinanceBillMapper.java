package com.smart.car.finance.mapper;

import com.smart.car.finance.entity.FinanceBill;
import com.smart.car.finance.entity.FinanceBillExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FinanceBillMapper {
    long countByExample(FinanceBillExample example);

    int deleteByExample(FinanceBillExample example);

    int deleteByPrimaryKey(String id);

    int insert(FinanceBill record);

    int insertSelective(FinanceBill record);

    List<FinanceBill> selectByExample(FinanceBillExample example);

    FinanceBill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FinanceBill record, @Param("example") FinanceBillExample example);

    int updateByExample(@Param("record") FinanceBill record, @Param("example") FinanceBillExample example);

    int updateByPrimaryKeySelective(FinanceBill record);

    int updateByPrimaryKey(FinanceBill record);
}