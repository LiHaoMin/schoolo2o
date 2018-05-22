package com.lihaomin.schoolo2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lihaomin.schoolo2o.mapper")
public class Schoolo2oApplication {

	public static void main(String[] args) {
		SpringApplication.run(Schoolo2oApplication.class, args);
	}
}
