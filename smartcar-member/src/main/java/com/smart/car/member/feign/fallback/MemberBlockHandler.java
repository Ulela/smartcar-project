package com.smart.car.member.feign.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.constant.Constants;
import lombok.extern.slf4j.Slf4j;

/**
 * sentinel提供，当超出“流控”规则时，触发限流，则调用blockHandler指定的接口。
 * @author chenf
 * @version 1.0
 * @date 2022-07-17
 */
@Slf4j
public class MemberBlockHandler {
    /**
     * 使用了blockHandlerClass来指定对应类，
     * 1.返回类型和参数类型都必须和原方法一致.
     * 2.方法必须为static，否则无法解析！！！
     * 3.方法必须带BlockException，否则找不到响应方法
     * 4.方法必须为public，访问范围
     */
    public static ResponseResult<String> blackException(BlockException e){
        log.error("blockHandler被触发，sentinel进行限流:{}",e.getMessage());
        ResponseResult<String> result = new ResponseResult<>();
        result.setCode(Constants.SERVICE_UNAVAILABLE);
        if (e instanceof FlowException) {
            result.setMsg("违反配置规则，接口被限流了");
        } else if (e instanceof DegradeException) {
            result.setMsg("违反配置规则，服务被降级了");
        } else if (e instanceof ParamFlowException) {
            result.setMsg("违反配置规则，被热点参数限流了");
        } else if (e instanceof SystemBlockException) {
            result.setMsg("违反配置规则，触发系统保护规则了");
        } else if (e instanceof AuthorityException) {
            result.setMsg("违反配置规则，授权规则不通过了");
        }
        return result;
    }

    //参数不同，针对的方法不同。
    public static ResponseResult<String> blackException(String id, BlockException e){
        log.error("blockHandler被触发sentinel限流,快速响应:{}"+ e.getMessage());
        ResponseResult<String> result = new ResponseResult<>();
        result.setCode(Constants.SERVICE_UNAVAILABLE);
        if (e instanceof FlowException) {
            result.setMsg("违反配置规则，接口被限流了");
        } else if (e instanceof DegradeException) {
            result.setMsg("违反配置规则，服务被降级了");
        } else if (e instanceof ParamFlowException) {
            result.setMsg("违反配置规则，被热点参数限流了");
        } else if (e instanceof SystemBlockException) {
            result.setMsg("违反配置规则，触发系统保护规则了");
        } else if (e instanceof AuthorityException) {
            result.setMsg("违反配置规则，授权规则不通过了");
        }
        return result;
    }
}
