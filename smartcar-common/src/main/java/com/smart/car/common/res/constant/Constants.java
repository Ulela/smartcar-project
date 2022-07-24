package com.smart.car.common.res.constant;

/**
 * 常量
 * @author chenf
 * @version 1.0
 * @date 2022-07-13
 */
public class Constants {
    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;
    public static final String SUMSG = "请求成功";
    public static final Integer VALID_EXCEPTION_CODE = 400;
    public static final String VALID_EXCEPTION_MSG = "参数校验异常";
    public static final Integer UNKNOWN_EXCEPTION_CODE = 500;

    public static final String UNKNOWN_EXCEPTION_MSG = "未知错误异常";
    public static final Integer SERVICE_UNAVAILABLE = 500;



    /**
     * 对象创建成功
     */
    public static final Integer CREATED = 201;

    /**
     * 请求已经被接受
     */
    public static final Integer ACCEPTED = 202;

    /**
     * 操作已经执行成功，但是没有返回数据
     */
    public static final Integer NO_CONTENT = 204;

    /**
     * 资源已被移除
     */
    public static final Integer MOVED_PERM = 301;

    /**
     * 重定向
     */
    public static final Integer SEE_OTHER = 303;

    /**
     * 资源没有被修改
     */
    public static final Integer NOT_MODIFIED = 304;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    public static final Integer BAD_REQUEST = 400;

    /**
     * 未授权
     */
    public static final Integer UNAUTHORIZED = 401;

    /**
     * 访问受限，授权过期
     */
    public static final Integer FORBIDDEN = 403;

    /**
     * 资源，服务未找到
     */
    public static final Integer NOT_FOUND = 404;

    /**
     * 不允许的http方法
     */
    public static final Integer BAD_METHOD = 405;

    /**
     * 资源冲突，或者资源被锁
     */
    public static final Integer CONFLICT = 409;

    /**
     * 不支持的数据，媒体类型
     */
    public static final Integer UNSUPPORTED_TYPE = 415;

    /**
     * 失败标记
     * 系统内部错误
     */
    public static final Integer FAIL = 500;

    /**
     * 接口未实现
     */
    public static final int NOT_IMPLEMENTED = 501;

    /**
     * 加入会员
     * 状态-会员1否0是
     */
    public static final Integer IS_MEMBERVIP = 0;
    public static final Integer NOT_MEMBERVIP = 1;

    /**
     * 初始化缓存信息
     * 计费规则cache
     */
    public static final class cache {
        public static final String CHARGINGRULE = "ruleKey";        //收费规则key
        public static final String currentAviableStallAmt = "currentAviableStallAmtKey"; //可用券key
        public static final String grouponCodeAmtKey = "grouponCodeAmt";    //兑换码key
        public static final int grouponCodeAmt = 10;
    }
    /**
     * 积分兑换券锁名
     */
    public static final class lock {
        public static final String exchangeCouponLock = "exchangeCouponLock";
    }
}
