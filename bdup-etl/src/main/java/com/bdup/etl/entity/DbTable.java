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
@TableName("bdup.db_table")
@ApiModel(value="DbTable对象", description="数据源表")
public class DbTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表ID")
    @TableId(value = "tableid", type = IdType.INPUT)
    private String tableid;

    @ApiModelProperty(value = "目标表用户")
    private String targetowner;

    @ApiModelProperty(value = "目标表名")
    private String targettable;

    @ApiModelProperty(value = "目标库类型")
    private String targetdbtype;

    @ApiModelProperty(value = "表注释")
    private String tablecomments;

    @ApiModelProperty(value = "表状态")
    private String state;

    @ApiModelProperty(value = "数据源ID")
    private String dbid;

    @ApiModelProperty(value = "源用户")
    private String sourceowner;

    @ApiModelProperty(value = "原表名")
    private String sourcetable;

    @ApiModelProperty(value = "源库类型")
    private String sourcedbtype;

    @ApiModelProperty(value = "抽取方式table、query、file")
    private String loadtype;

    @ApiModelProperty(value = "抽取工具")
    private String loadtool;

    @ApiModelProperty(value = "同步方式一次性、实时、按周期")
    private String syncmethod;

    @ApiModelProperty(value = "增量对比字段")
    private String appendbycolumn;

    @ApiModelProperty(value = "corn")
    private String cron;

    private String haspk;

    private String cshbz;

    @ApiModelProperty(value = "错误信息")
    private String errtext;

    @ApiModelProperty(value = "datax脚本")
    private String dataxscript;

    @ApiModelProperty(value = "hdfs脚本")
    private String hdfsscript;

    @ApiModelProperty(value = "oracle脚本")
    private String oraclescript;

    @ApiModelProperty(value = "postgres脚本")
    private String postgresscript;

    @ApiModelProperty(value = "phoenix脚本")
    private String phoenixscript;

    @ApiModelProperty(value = "操作人")
    private String czy;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime czsj;


}
