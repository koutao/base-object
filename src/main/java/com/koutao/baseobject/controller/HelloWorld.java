package com.koutao.baseobject.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.koutao.baseobject.config.model.ResultModel;
import com.koutao.baseobject.entity.Dept;
import com.koutao.baseobject.service.DeptService;
import com.koutao.baseobject.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorld {


    @Autowired
    private DeptService deptService;

    @Resource
    private DataSource dataSource;

    @GetMapping("/sayHi")
    public String sayHi(){
        return "HelloWorld!";
    }

    @GetMapping("/say2")
    public ResultModel<String> sayHi2(){
        return new ResultModel<>("HelloWorld!");
    }

    @GetMapping("/say3")
    public void say3() throws Exception{
        System.out.println(dataSource.getConnection().toString());
    }

    @GetMapping("/list")
    public List<Dept> listDetp(){
        return deptService.selectList(null);
    }


}
