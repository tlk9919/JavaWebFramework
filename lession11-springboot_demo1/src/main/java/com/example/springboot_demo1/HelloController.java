package com.example.springboot_demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 * @classnam HelloController
 * @time 15:27
 * @date 2024/11/5
 */
@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("/")
    public String say(){
        return "hello springboot web-idea";
    }
}
