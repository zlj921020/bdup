package com.bdup.etl.entity;

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
 * 数据源表
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bdup.db_pool")
@ApiModel(value="DbPool对象", description="数据源表")
public class DbPool implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "DBID")
    @TableId(value = "dbid", type = IdType.INPUT)
    private String dbid;

    @ApiModelProperty(value = "数据源编号")
    private String dbbh;

    @ApiModelProperty(value = "数据源名称")
    private String dbname;

    @ApiModelProperty(value = "数据源IP")
    private String dbip;

    @ApiModelProperty(value = "数据源PORT")
    private String dbport;

    @ApiModelProperty(value = "数据源实例")
    private String dborcl;

    @ApiModelProperty(value = "登录用户")
    private String loginname;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "数据源类型")
    private String sourcedbtype;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "中间件")
    private String sync;

    @ApiModelProperty(value = "TOPIC名称")
    private String topic;

    @ApiModelProperty(value = "操作员")
    private String czy;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime czsj;


}
