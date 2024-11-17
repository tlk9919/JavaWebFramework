package com.example.lession12springconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @classnam MyConfig
 * @time 15:18
 * @date 2024/11/12
 */
@Component
@ConfigurationProperties(prefix = "myconfig")
//注解表示该类会从外部配置文件（如 application.properties 或 application.yml）中获取以 myconfig 为前缀的配置属性，并将这些属性自动绑定到该类的字段上。
public class MyConfig {

    private String name;

    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MyConfig{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }



}
