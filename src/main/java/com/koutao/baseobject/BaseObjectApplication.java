package com.koutao.baseobject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.koutao.baseobject.dao*")
public class BaseObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseObjectApplication.class, args);
	}
}
