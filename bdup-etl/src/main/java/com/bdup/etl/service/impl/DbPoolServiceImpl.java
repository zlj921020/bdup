package com.bdup.etl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdup.etl.entity.DbPool;
import com.bdup.etl.mapper.DbPoolMapper;
import com.bdup.etl.service.DbPoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 数据源表 服务实现类
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Service
public class DbPoolServiceImpl extends ServiceImpl<DbPoolMapper, DbPool> implements DbPoolService {
   @Autowired
   DbPoolMapper dbPoolMapper;
    @Override
    public List<HashMap> getDbPoolSelect() {
        List<HashMap> hashMaps = dbPoolMapper.getDbPoolSelect();
        return hashMaps;
    }


    /**
     * 保存数据库链接
     *
     * @author zlj
     * @date 创建时间 2018-05-11
     * @since V1.0
     */
    public void saveDbPool(DbPoolDto dbPoolDto) throws Exception {
        String[] dbbhs = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "U", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};

        List<String> dbbhList = new ArrayList<>(Arrays.asList(dbbhs));
        DataStore dbKafkaConsumers = para.getDataStore("dbkafkaconsumers");
        String dbfullname = para.getString("dbfullname");
        String loginname = para.getString("loginname");

        String sourcedbtype = para.getString("sourcedbtype");
        String sync = para.getString("sync");
        String version = para.getString("version");
        String password = para.getString("password");
        String dbip = para.getString("dbip");
        String dbport = para.getString("dbport");
        String dborcl = para.getString("dborcl");
        String zlbz = para.getString("zlbz");
        String topic = para.getString("topic");

        // 密码加密用到的时候再次解密
        password = BdupTools.encryptData(password, "sm4");
        // 判断是否有重复
        DbPool dbPoolAlready = getOne(new QueryWrapper<DbPool>().eq("dbfullname", dbfullname));
        if (dbPoolAlready != null) {
            throw new Exception("已存在名称为:" + dbfullname + "的数据源信息");
        }
        // 判断是否有重复
        List<DbPool> DbPools = list(new QueryWrapper<DbPool>().eq("dbip", dbip)
                .eq("dbport", dbport)
                .eq("dborcl", dborcl));
        if (DbPools.size() > 0) {
            throw new Exception("数据库中存在与之重复的数据源信息！");
        }

        // 获取数据编号信息
        DbPools = this.list();
        String dbbh = "A";// dbbh用来助记的，方便拼装映射表的表名，dbid太复杂不方便使用
        for (int i = 0; i < DbPools.size(); i++) {
            dbbhList.remove(DbPools.get(i).getDbbh());
        }

        dbbh = dbbhList.get(0);
        // 获取dbid
        DbPool dbPool = DbPool.builder()
                .dbbh(dbbh)
                .dbfullname(dbfullname)
                .dbip(dbip)
                .dbport(dbport)
                .dborcl(dborcl)
                .loginname(loginname)
                .password(password)
                .sourcedbtype(sourcedbtype)
                .sync(sync)
                .topic(topic)
                .czy(CurrentUserUtil.getUser().getUserid())
                .czsj(new Date())
                .version(version)
                .zlbz(zlbz)
                .build();
        save(dbPool);

        //校验是否有重复
        for (int i = 0; i < dbKafkaConsumers.size(); i++) {
            int partition = dbKafkaConsumers.getInt(i, "partition");
            String targetdbtype = dbKafkaConsumers.getString(i, "targetdbtype");

            DbKafkaConsumer dbKafkaConsumer = DbKafkaConsumer.builder().topic(topic).partition(partition).targetdbtype(targetdbtype).ztbz("0").build();
            dbKafkaConsumerService.save(dbKafkaConsumer);
            KafkaTaskGuard.addKafkaTaskGuard(targetdbtype, sourcedbtype, dbbh, topic, partition, sync);
        }

        // 记录日志
        bizLogService.saveLog("SJCQ", "SJCQ_ADD_DBPOOL", "数据源名称：" + dbfullname);
        return null;
    }
}
