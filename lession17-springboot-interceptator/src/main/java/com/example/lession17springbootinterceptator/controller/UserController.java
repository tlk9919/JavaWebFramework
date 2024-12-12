package com.example.lession17springbootinterceptator.controller;

import com.example.lession17springbootinterceptator.model.User;
import com.example.lession17springbootinterceptator.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Your Name
 * @since 2024-12-10
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //展示登录界面
    @GetMapping("/login")
    public  String login(){
        //返回的视图
        return "login";
    }
    //处理登录
    @PostMapping("/doLogin")
    public String login(@ModelAttribute User user, Model model, HttpSession session){
        //打印前端传来的数据
        System.out.println("user" + user);
        //校验用户名密码，service层
        boolean flag= userService.doLogin(user);
        if (flag){
            //登录成功保存会话的用户名
            session.setAttribute("username",user.getUsername());//key-vaule形式
            System.out.println("login sucess");
            return  "student";
        }
        else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }

    }

}
