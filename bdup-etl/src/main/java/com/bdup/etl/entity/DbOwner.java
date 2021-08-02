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
 * 数据源用户表
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bdup.db_owner")
@ApiModel(value="DbOwner对象", description="数据源用户表")
public class DbOwner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ownerid", type = IdType.INPUT)
    private String ownerid;

    private String targetowner;

    private String targetdbtype;

    private String dbid;

    private String sourceowner;

    private String tsspace;

    private String tsispace;

    private String czy;

    private LocalDateTime czsj;


}
