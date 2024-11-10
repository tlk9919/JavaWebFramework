package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DriverManager;

/**
 * @author admin
 * @classnam SpringConfig
 * @time 15:26
 * @date 2024/10/21
 */

@Configuration
@ComponentScan("com.example")
public class SpringConfig {
    @Bean
    public DataSource dataSource(){  //DataSource接口提供了一种获取数据库连接的方法，
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javaweb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
