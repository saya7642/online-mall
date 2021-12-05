package com.example.mpg.generator;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.Service;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.mpg.base.BaseController;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MybatisAutoGenerator {

    private static final String db = "new_mall";
    private static final String username = "root";
    private static final String password = "123456";
    private static final String url = "jdbc:mysql://localhost:3306/" + db + "?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2b8";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String dir = System.getProperty("user.dir") + "/src/main/java/";
    private static final String basePackage = "com.example.mpg";

    @Test
    public void main() {
        String[] tables = getTables();
        Arrays.stream(tables).forEach(System.out::println);
    }

    @Test
    public void run() {
        execute();
    }

    /**
     * 全局配置
     */
    private GlobalConfig globalConfig() {
        return new GlobalConfig.Builder()
                .author("admin") // 设置作者
                .fileOverride() // 覆盖已生成文件
                .commentDate("yyyy-MM-dd")
                .outputDir(dir) // 指定输出目录
                .disableOpenDir()
                .build();
    }

    /**
     * 策略配置
     */
    private StrategyConfig strategyConfig() {
        StrategyConfig.Builder builder = new StrategyConfig.Builder()
                .addInclude(getTables()) // 设置需要生成的表名
                .addTablePrefix("t_");

        builder.mapperBuilder()
                .enableBaseResultMap();

        builder.serviceBuilder()
                .formatServiceFileName("%sService");

        builder.entityBuilder()
                .enableLombok()
                .enableChainModel()
                .enableActiveRecord();

        builder.controllerBuilder()
                .enableRestStyle()
                .superClass(BaseController.class)
                .build(); // 设置过滤表前缀

        return builder.build();
    }

    /**
     * 模板配置
     */
    private TemplateConfig templateConfig() {
        return new TemplateConfig.Builder()
                .controller("/template/controller.java")
                .build();
    }

    /**
     * 包配置
     */
    private PackageConfig packageConfig() {
        return new PackageConfig.Builder()
                .parent(basePackage) // 设置父包名;
                .build();
    }

    /**
     * 注入配置
     */
    private InjectionConfig injectionConfig() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        return new InjectionConfig.Builder()
                .beforeOutputFile((tableInfo, objectMap) -> {
                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                    objectMap.put("entityUpper",tableInfo.getEntityName());
                    objectMap.put("entityLower", StrUtil.lowerFirst(tableInfo.getEntityName()));
                    System.out.println(objectMap);
                })
                .build();
    }

    private final DataSource DATA_SOURCE = getDataSource();

    /**
     * 数据源配置
     */
    private final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(DATA_SOURCE)
            .build();

    private DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Test
    public void execute() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.global(globalConfig())
                .strategy(strategyConfig())
                .injection(injectionConfig())
                .packageInfo(packageConfig())
                .template(templateConfig());
        generator.execute();
    }

    private String[] getTables() {
        Db db = DbUtil.use(DATA_SOURCE);
        String[] arr = new String[0];

        String sql = "select table_name from information_schema.tables where table_schema='" + MybatisAutoGenerator.db + "'";

        try {
            List<Entity> list = db.query(sql);
            ArrayList<String> tables = new ArrayList<>();
            list.forEach(entity -> tables.add(entity.getStr("table_name")));
            return tables.toArray(arr);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return arr;
    }
}
