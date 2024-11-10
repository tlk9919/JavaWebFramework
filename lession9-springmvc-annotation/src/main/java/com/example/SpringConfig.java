package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * @author admin
 * @classnam SpringConfig
 * @time 16:54
 * @date 2024/10/29
 */
@Configuration
@ComponentScan("com.example")
@EnableWebMvc
public class SpringConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javaweb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }

}
