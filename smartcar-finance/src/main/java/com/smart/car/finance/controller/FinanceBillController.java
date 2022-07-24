package com.smart.car.finance.controller;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.finance.entity.FinanceBill;
import com.smart.car.finance.service.FinanceBillService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO 财务账单控制
 *
 * @author: zoutao
 * @date: 2021-04-20
 */
@Slf4j
@RestController
@RequestMapping("billing")
@AllArgsConstructor
public class FinanceBillController {

    private final FinanceBillService billService;

    @GetMapping("/test")
    public String test() {
        log.info("hello-江湖一点雨");
        return "hello-world-江湖一点雨";
    }

    @RequestMapping("/list")
    public List<FinanceBill> list() {
        List<FinanceBill> messages = billService.list();
        log.debug("查询到的支付账单列表：{}" ,messages);
        return messages;
    }

    /**
     * 记录用户费用支付记录
     * @param json String
     * @return 0 or 1
     */
    @PostMapping("/create")
    public ResponseResult<Integer> create(String json) throws BusinessException {
        ResponseResult<Integer> result = new ResponseResult<>();
        int rtn = billService.create(json);
        result.setData(rtn);
        return result;
    }
}
