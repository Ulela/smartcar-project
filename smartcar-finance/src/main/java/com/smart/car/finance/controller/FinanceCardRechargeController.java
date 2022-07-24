package com.smart.car.finance.controller;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.exception.BusinessException;
import com.smart.car.finance.service.FinanceCardRechargeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@RestController
@RequestMapping("recharge")
@AllArgsConstructor
public class FinanceCardRechargeController {

    private final FinanceCardRechargeService rechargeService;

    /**
     * 记录会员充值记录
     * @author zoutao.blog.csdn.net
     */
    @PostMapping("/create")
    public ResponseResult<Integer> create(String json) throws BusinessException {
        ResponseResult<Integer> commonResult = new ResponseResult<>();
        int rtn = rechargeService.create(json);
        commonResult.setData(rtn);
        return commonResult;
    }
}
