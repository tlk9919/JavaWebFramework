package com.example.springAuto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @classnam SpringConfig
 * @time 17:10
 * @date 2024/10/15
 */
@Configuration
@ComponentScan("com.example.springAuto")//Spring 会自动发现并注册用 @Component、@Service、@Repository 和 @Controller 等注解标记的类作为 Spring Bean
public class SpringConfig {
    @Bean
    public JdbcConfig createJdbcConfig(){

        return new JdbcConfig();//JdbcConfig jdbcConfig=new JdbcConfig();  return jdbcConfig;


    }
}
