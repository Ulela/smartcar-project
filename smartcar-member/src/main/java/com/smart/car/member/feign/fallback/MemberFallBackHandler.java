package com.smart.car.member.feign.fallback;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.constant.Constants;
import lombok.extern.slf4j.Slf4j;

/**
 * sentinel提供，当方法运行过程中出现“异常”时，
 * 则触发熔断机制快速响应，调用fallback指定的接口。
 * @author chenf
 * @version 1.0
 * @date 2022-07-17
 */
@Slf4j
public class MemberFallBackHandler {
    /**
     * 使用了fallbackClass指定的对应类，
     * 方法必须为static，否则无法解析！！！
     * 方法必须带Throwable，否则找不到响应方法
     * 方法必须为public，访问范围
     */
    public static ResponseResult<String> memberFallBack(Throwable e){
        log.error("进入兜底方法，触发异常Fallback，异常内容:{}", e.getMessage());
        ResponseResult<String> result = new ResponseResult<>();
        String data = "";
        if (e instanceof NullPointerException) {
            data =  "空指针了..."+e.getMessage();
        }else if (e instanceof ClassNotFoundException) {
            data =  "找不到了..."+e.getMessage();
        }else if (e instanceof ArithmeticException){
            data =  "不可为零异常.."+e.getMessage();
        }else if(e instanceof RuntimeException){
            data =  "服务疑似不可用，已宕机.."+e.getMessage();
        }else{
            data =  "服务产生未知异常..."+e.getMessage();
        }
        result.setCode(Constants.SERVICE_UNAVAILABLE);
        result.setMsg("远程调用的目标服务运行异常，启动熔断，调用快速失败处理。");
        result.setData(data);
        return result;
    }
    //参数不同，针对的方法不同。
    public static ResponseResult<String> memberFallBack(String id, Throwable e){
        log.error("进入兜底方法，触发异常Fallback，异常内容:{}", e.getMessage());
        ResponseResult<String> result = new ResponseResult<>();
        String data = "";
        if (e instanceof NullPointerException) {
            data =  "出现空指针了..."+e.getMessage();
        }else if (e instanceof ClassNotFoundException) {
            data =  "类找不到了..."+e.getMessage();
        }else if (e instanceof ArithmeticException){
            data =  "数值不可为零..."+e.getMessage();
        }else if(e instanceof RuntimeException){
            data =  "服务疑似不可用，已宕机.."+e.getMessage();
        }else{
            data =  "服务产生未知异常..."+e.getMessage();
        }
        result.setCode(Constants.SERVICE_UNAVAILABLE);
        result.setMsg("远程调用的目标服务运行异常，启动熔断，调用快速失败处理。");
        result.setData(data);
        return result;
    }
}
