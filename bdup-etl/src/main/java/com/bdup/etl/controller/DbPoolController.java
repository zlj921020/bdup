package com.bdup.etl.controller;


import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdup.core.Result;
import com.bdup.etl.entity.DbDriver;
import com.bdup.etl.entity.DbPool;
import com.bdup.etl.service.DbDriverService;
import com.bdup.etl.service.DbPoolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 数据源表 前端控制器
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@RestController
@RequestMapping("/etl/dbpool")
public class DbPoolController {
    @Autowired
    DbPoolService dbPoolService;

    @Autowired
    DbDriverService dbDriverService;

    /**
     * 获取数据库链接信息
     *
     * @author zlj
     * @date 创建时间 2018-5-11
     * @since V1.0
     */
    @ApiOperation(value = "获取所有数据源信息")
    @PostMapping("/getDbPoolInfo")
    public Result getDbPoolInfo() throws Exception {
        List<DbPool> dbPools = dbPoolService.list();
        Dict dict = Dict.create()
                .set("dbpool", dbPools);
        return Result.success(dict);
    }

    /**
     * 获取数据库select
     *
     * @author zlj
     * @date 创建时间 2018-5-11
     * @since V1.0
     */
    @ApiOperation(value = "获取数据源的下拉框select选项")
    @PostMapping("/getDbPoolSelect")
    public Result getDbPoolSelect() throws Exception {
        List<HashMap> dbPoolSelect = dbPoolService.getDbPoolSelect();
        Dict dict = Dict.create()
                .set("dbPoolSelect", dbPoolSelect);
        return Result.success(dict);
    }


    /**
     * 测试数据库链接
     *
     * @author zlj
     * @date 创建时间 2018-05-09
     * @since V1.0
     */
    @ApiOperation(value = "测试数据库连接是否正常")
    @PostMapping("/chkDbConnection")
    public Result chkDbConnection(@RequestBody DbPool req) throws Exception {
        // 获取数据库驱动
        DbDriver dbtype = dbDriverService.getOne(new QueryWrapper<DbDriver>().eq("dbtype", req.getSourcedbtype()));

        if (dbtype == null || "".equals(dbtype)) {
            throw new Exception("数据库中不存在对应的驱动信息，请检查");
        }

        String driver = dbtype.getDriver();
        String url = dbtype.getUrl();
        url = url.replace("ip", req.getDbip()).replace("port", req.getDbport()).replace("dbname", req.getDborcl());
        Connection connection = null;

        try {
            // 获取连接
            Class.forName(driver);
            connection = DriverManager.getConnection(url, req.getLoginname(), req.getPassword());
        } catch (Exception e) {
            throw new Exception("链接失败：" + e.getMessage());
        } finally {
            connection.close();
        }
        return  Result.success();
    }

    /**
     * 保存数据库链接
     *
     * @author zlj
     * @date 创建时间 2018-05-11
     * @since V1.0
     */
    @ApiOperation(value = "保存数据库链接")
    @PostMapping("/saveDbPool")
    public Result saveDbPool(@RequestBody DbPool req) {
        dbPoolService.saveDbPool(req);
        return Result.success();
    }

    /**
     * 删除数据库链接
     *
     * @author zlj
     * @date 创建时间 2018-05-11
     * @since V1.0
     */
    @ApiOperation(value = "删除数据库链接")
    @PostMapping("/deleteDbPool")
    public Result deleteDbPool(@RequestParam String dbid, @RequestParam String dbfullname) {
        dbPoolService.deleteDbPool(dbid, dbfullname);
        return Result.success();
    }

}
