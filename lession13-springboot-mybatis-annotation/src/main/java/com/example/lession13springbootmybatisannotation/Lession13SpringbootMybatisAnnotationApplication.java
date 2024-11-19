package com.example.lession13springbootmybatisannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lession13springbootmybatisannotation.dao")
public class Lession13SpringbootMybatisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lession13SpringbootMybatisAnnotationApplication.class, args);
	}

}
