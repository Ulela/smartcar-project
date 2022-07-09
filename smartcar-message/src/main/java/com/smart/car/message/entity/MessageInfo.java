package com.smart.car.message.entity;

import lombok.Data;

import java.util.Date;

@Data
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