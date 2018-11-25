package com.koutao.baseobject.util;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AggGenerator {

    private static String packagePrefix = "com.koutao.baseobject";
    private static String authorName="koutao";     //作者
    private static String table="dept";                  //table名字
    private static String prefix="sc_";                     //table前缀
    private static String path = new File("").getAbsolutePath();

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://192.168.168.128:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String userName = "root";
    private static String passWord = "123456";


    public static void main(String[] args) {
        testGenerator();
    }

    /**
     * 代码生成    示例代码
     */
    public static void testGenerator() {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor(authorName) // 作者
                .setOutputDir(path + "\\src\\main\\java") // 生成路径
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(true)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setOpen(false)//生成后打开文件夹
                .setIdType(IdType.AUTO)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");

        //2. 数据源配置
        DataSourceConfig dsConfig  = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName(driverName)
                .setUrl(url)
                .setUsername(userName)
                .setPassword(passWord);

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix("tbl_")
                .setInclude(table) // 生成的表
                .setSuperControllerClass(packagePrefix  +".controller.AbstractController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                .setEntityLombokModel(true);
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent(packagePrefix)
                .setMapper("dao")
                .setService("service")
                .setController("controller")
                .setEntity("entity");

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig ijConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+"/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        }));

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig)
                .setCfg(ijConfig)
                .setTemplate(new TemplateConfig().setXml(null).setController(null));

        //6. 执行
        ag.execute();
    }

}
