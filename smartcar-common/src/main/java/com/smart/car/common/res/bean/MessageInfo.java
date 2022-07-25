package com.smart.car.common.res.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class MessageInfo {
    private String id;

    private String mtype;

    private String mcontent;

    private String memberId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remark;

    private Integer version;

    private Integer state;
}