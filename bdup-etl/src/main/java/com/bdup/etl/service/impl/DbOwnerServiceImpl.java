package com.bdup.etl.service.impl;

import com.bdup.etl.entity.DbOwner;
import com.bdup.etl.mapper.DbOwnerMapper;
import com.bdup.etl.service.DbOwnerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据源用户表 服务实现类
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Service
public class DbOwnerServiceImpl extends ServiceImpl<DbOwnerMapper, DbOwner> implements DbOwnerService {

}
