package com.smart.car.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
/**
 * @description 用户/会员信息表
 * @author zoutao.blog.csdn.net
 * @date 2021-03-03
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "用户/会员信息表")
public class MemberUser {

    private String id;

    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1]+\\d{10}$",message = "手机号格式错误")
    private String phone;

    @ApiModelProperty("生日")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Pattern(message = "无效的出生日期!",regexp = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")
    private String birth;

    @ApiModelProperty("真实姓名")
    @NotBlank(message = "姓名不能为空")
    @Size(min=2, max=8,message = "您的名字也太长了吧~")
    private String realName;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 12, message = "长度必须是6-12个字符")
    private String password;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建日期")
    private Date createDate;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新日期")
    private Date updateDate;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("版本号")
    private Integer version;

    @ApiModelProperty("状态-会员1否0是")
    private Integer state;
}
