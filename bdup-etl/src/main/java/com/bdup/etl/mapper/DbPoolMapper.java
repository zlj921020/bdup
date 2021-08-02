package com.bdup.etl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdup.etl.entity.DbPool;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 数据源表 Mapper 接口
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
public interface DbPoolMapper extends BaseMapper<DbPool> {

    @Select("select dbid as value, dbfullname as label from bdup.db_pool")
    List<HashMap> getDbPoolSelect();
}
