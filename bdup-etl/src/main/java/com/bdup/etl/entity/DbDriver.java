package com.bdup.etl.entity;

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
 * 驱动配置表
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bdup.db_driver")
@ApiModel(value="DbDriver对象", description="驱动配置表")
public class DbDriver implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据源类型")
    @TableId(value = "dbtype", type = IdType.INPUT)
    private String dbtype;

    @ApiModelProperty(value = "驱动")
    private String driver;

    @ApiModelProperty(value = "URL模板")
    private String url;


}
