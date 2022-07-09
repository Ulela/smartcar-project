package com.smart.car.finance.mapper;

import com.smart.car.finance.entity.FinanceCardRecharge;
import com.smart.car.finance.entity.FinanceCardRechargeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FinanceCardRechargeMapper {
    long countByExample(FinanceCardRechargeExample example);

    int deleteByExample(FinanceCardRechargeExample example);

    int deleteByPrimaryKey(String id);

    int insert(FinanceCardRecharge record);

    int insertSelective(FinanceCardRecharge record);

    List<FinanceCardRecharge> selectByExample(FinanceCardRechargeExample example);

    FinanceCardRecharge selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FinanceCardRecharge record, @Param("example") FinanceCardRechargeExample example);

    int updateByExample(@Param("record") FinanceCardRecharge record, @Param("example") FinanceCardRechargeExample example);

    int updateByPrimaryKeySelective(FinanceCardRecharge record);

    int updateByPrimaryKey(FinanceCardRecharge record);
}