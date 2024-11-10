package com.example.springAuto;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author admin
 * @classnam JdbcConfig
 * @time 16:25
 * @date 2024/10/15
 */
public class JdbcConfig {
    @Value("com.mysql.cj.driver")
    private String driver;

    @Value("jdbc:mysql://localhost:3306/db_data")
    private String url;

    @Value("root")
    private  String username;

    @Value("123123")
    private  String password;

    @Override
    public String toString() {
        return "JdbcConfig{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
