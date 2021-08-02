package com.bdup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统CODE表
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bdup.sys_code")
@ApiModel(value="SysCode对象", description="系统CODE表")
public class SysCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "代码编号")
    @TableId(value = "dmbh", type = IdType.INPUT)
    private String dmbh;

    @ApiModelProperty(value = "CODE值")
    private String code;

    @ApiModelProperty(value = "CODE名称")
    private String content;

    @ApiModelProperty(value = "序号")
    private BigDecimal xh;


}
