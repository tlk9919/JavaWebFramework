package com.example.starwhisper_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.example.starwhisper_server.dao")
@EnableAsync
public class StarWhisperServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWhisperServerApplication.class, args);
    }

}
