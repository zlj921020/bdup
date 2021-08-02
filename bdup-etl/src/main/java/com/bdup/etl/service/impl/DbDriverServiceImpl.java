package com.bdup.etl.service.impl;

import com.bdup.etl.entity.DbDriver;
import com.bdup.etl.mapper.DbDriverMapper;
import com.bdup.etl.service.DbDriverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 驱动配置表 服务实现类
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Service
public class DbDriverServiceImpl extends ServiceImpl<DbDriverMapper, DbDriver> implements DbDriverService {

}
