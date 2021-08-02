package com.bdup.etl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdup.etl.entity.DbPool;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 数据源表 服务类
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
public interface DbPoolService extends IService<DbPool> {

    List<HashMap> getDbPoolSelect();

    void saveDbPool(DbPool req);
}
