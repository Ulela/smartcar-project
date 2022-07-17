package com.smart.car.common.res.exception;

/**
 * 2.业务异常处理类
 * @author chenf
 * @version 1.0
 * @date 2022-07-13
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String module, String code, Object[] args, String defaultMessage) {
        super(module, code, args, defaultMessage);
    }

    public BusinessException(String module, String code, Object[] args) {
        super(module, code, args);
    }

    public BusinessException(String module, String defaultMessage) {
        super(module, defaultMessage);
    }

    public BusinessException(String code, Object[] args) {
        super(code, args);
    }

    public BusinessException(String defaultMessage) {
        super(defaultMessage);
    }
}