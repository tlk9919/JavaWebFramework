package com.example.lession15springbootthymeleaf;

import org.springframework.ui.Model;  // 应该是这个

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author admin
 * @classnam HelloController
 * @time 15:22
 * @date 2024/12/2
 */
@Controller
public class HelloController {
    // 1. 处理 /test 请求
    @GetMapping("/test")
    public String test(Model model) {
        // 2. 在 Model 中添加 "name" 和 "desc" 属性，并为其赋值
        model.addAttribute("name", "welcome <br> zhangsan");
        model.addAttribute("desc", "This is a Demo<br>!!!");
        // 3. 创建一个 User 对象并设置其属性
        User user =new User();
        user.setId(1000);
        user.setRole("user");
        user.setUsername("root");
        user.setPassword("123456");
        user.setVIP(false);
        user.setTags(List.of("乐观","自信"));

        user.setBirthDate(LocalDate.of(2000,1,1));
        user.setLoginTime(LocalTime.of(16,30,00));
        user.setRegistrationDateTime(LocalDateTime.of(2024,12,1,16,30,30));

        //输出 user 对象的内容到控制台，通常用于调试
        System.out.println(user);

//        将 user 对象添加到 Model 中，供视图页面使用
        model.addAttribute("user", user);
        return "test";
    }
    @GetMapping("/detail")
    public String getByID(Model model, @RequestParam("id") int id) {
        model.addAttribute("msg","收到传来的id:"+id);
        return "detail";
    }

}
