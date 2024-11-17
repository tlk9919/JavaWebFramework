package com.example.lession12springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @classnam HelloController
 * @time 16:37
 * @date 2024/11/12
 */
@RestController
public class HelloController {

    @Autowired
    private ProjectConfig projectConfig;

    @GetMapping("/hello")
    public String welcome(){

        return projectConfig.toString();
    }


}
