package com.smart.car.finance.service;

import com.smart.car.finance.entity.FinanceBill;

import java.util.List;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
public interface FinanceBillService {
    List<FinanceBill> list();
    int create(String json);
}
