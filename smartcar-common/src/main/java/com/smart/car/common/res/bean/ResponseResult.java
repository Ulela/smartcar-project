package com.smart.car.common.res.bean;

import com.smart.car.common.res.constant.Constants;
import lombok.Data;

import java.io.Serializable;

/**
 * 公共返回体
 *
 * @author chenf
 * @version 1.0
 * @date 2022-07-13
 */
@Data
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 返回的状态码
     */
    private int code;
    /**
     * 返回的信息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private T data;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;
    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

    public static <T> ResponseResult<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> ResponseResult<T> ok(T data) {
        return restResult(data, SUCCESS, Constants.SUMSG);
    }

    public static <T> ResponseResult<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> ResponseResult<T> fail() {
        return restResult(null, FAIL, null);
    }

    public static <T> ResponseResult<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> ResponseResult<T> fail(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> ResponseResult<T> fail(T data, String msg) {
        return restResult(data, FAIL, msg);
    }

    public static <T> ResponseResult<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    public boolean isSuccess() {
        return this.code == SUCCESS;
    }

    private static <T> ResponseResult<T> restResult(T data, int code, String msg) {
        ResponseResult<T> apiResult = new ResponseResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
