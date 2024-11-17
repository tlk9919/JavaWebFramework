package com.example.lession12springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @classnam EnviromentController
 * @time 16:49
 * @date 2024/11/12
 */
@RestController
public class EnviromentController {

    @Autowired
    private Environment environment;

    @GetMapping("/port")
    public String en(){
        String port=environment.getProperty("server.port");
        return "端口：\t"+port;
    }

    @GetMapping("/redis")
    public String en1() {
        String host = environment.getProperty("redis.host");
        String port = environment.getProperty("redis.port");
        return "redis <br>host:\t" + host + "\nport:" + port;
    }

    @GetMapping("/mysql")
    public String en2() {
        String dcn = environment.getProperty("spring.datasource.driver-class-name");
        String url = environment.getProperty("spring.datasource.url");
        String uname = environment.getProperty("spring.datasource.username");
        String pwd = environment.getProperty("spring.datasource.password");
        return "mysql config:<br>" + "driver class name:" + dcn + "<br>url:" + url + "<br>username:" + uname + "<br>password:" + pwd;
    }

}
