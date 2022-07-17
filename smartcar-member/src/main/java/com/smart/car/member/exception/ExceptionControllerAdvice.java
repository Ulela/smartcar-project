package com.smart.car.member.exception;

import com.smart.car.common.res.bean.ResponseResult;
import com.smart.car.common.res.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制层的全局异常处理
 * @author chenf
 * @version 1.0
 * @date 2022-07-13
 */
@SuppressWarnings("rawtypes")
@Slf4j
@RestControllerAdvice(basePackages = "com.smart.car.member.controller")
public class ExceptionControllerAdvice {

    //参数校验异常处理
    @ResponseBody
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseResult handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());
        // 从异常对象中拿到ObjectError对象
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError)->{
            // 提取错误提示信息
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        ResponseResult result = new ResponseResult();
        result.setCode(Constants.VALID_EXCEPTION_CODE);
        result.setMsg(Constants.VALID_EXCEPTION_MSG);
        result.setData(errorMap);
        return result;
    }

    //全局方法异常处理
    @ExceptionHandler(value=Throwable.class)
    public ResponseResult handleException(Throwable throwable) {
        log.error("未知异常{}，异常类型：{}", throwable.getMessage(), throwable.getClass());
        ResponseResult result = new ResponseResult();
        result.setCode(Constants.UNKNOWN_EXCEPTION_CODE);
        result.setMsg(Constants.UNKNOWN_EXCEPTION_MSG);
        return result;
    }
}
