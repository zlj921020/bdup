package com.bdup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bdup.sys_user")
@ApiModel(value="SysUser对象", description="")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "userid", type = IdType.INPUT)
    private String userid;

    @ApiModelProperty(value = "登录名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "展示名称，姓名")
    private String nickname;

    @ApiModelProperty(value = "是否是超级管理员")
    private String isadmin;

    @ApiModelProperty(value = "是否正常")
    private String enabled;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "钉钉")
    private String dingding;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "操作员")
    private String czy;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime czsj;


}
