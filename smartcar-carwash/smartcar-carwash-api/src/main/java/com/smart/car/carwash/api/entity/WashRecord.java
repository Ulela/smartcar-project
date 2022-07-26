package com.smart.car.carwash.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * dubbo的API实体-洗车服务记录表
 * @author chenf
 * @version 1.0
 * @date 2022-07-25
 */
@Data
@ApiModel("洗车记录表")
public class WashRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 洗车id
     */
    @ApiModelProperty("洗车id")
    private String id;

    /**
     * 用户编号
     */
    @ApiModelProperty("用户编号")
    private String memberId;

    /**
     * 车牌号
     */
    @ApiModelProperty("车牌号")
    private String plateNum;

    /**
     * 洗车券编码
     */
    @ApiModelProperty("洗车券编码")
    private String couponCode;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createBy;

    /**
     * 创建日期
     */
    @ApiModelProperty("创建日期")
    private Date createDate;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updateBy;

    /**
     * 更新日期
     */
    @ApiModelProperty("更新日期")
    private Date updateDate;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    private Integer version;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer state;
}
