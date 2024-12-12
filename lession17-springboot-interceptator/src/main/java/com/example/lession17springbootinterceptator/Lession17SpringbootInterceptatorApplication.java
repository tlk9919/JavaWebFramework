package com.example.lession17springbootinterceptator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lession17springbootinterceptator.dao")  // 添加这个注解
public class Lession17SpringbootInterceptatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession17SpringbootInterceptatorApplication.class, args);
    }

}