package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 * @classnam MyApplication
 * @time 15:15
 * @date 2024/11/5
 */
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
//        rgs：传递给 SpringApplication.run() 方法，传递命令行参数，Spring Boot 会将这些参数传递给应用的上下文。
    }
}
