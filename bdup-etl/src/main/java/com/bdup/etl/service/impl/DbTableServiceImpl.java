package com.bdup.etl.service.impl;

import com.bdup.etl.entity.DbTable;
import com.bdup.etl.mapper.DbTableMapper;
import com.bdup.etl.service.DbTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据源表 服务实现类
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Service
public class DbTableServiceImpl extends ServiceImpl<DbTableMapper, DbTable> implements DbTableService {

}
