package com.example.starwhisperserver.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.starwhisperserver.model.ApiResponse;
import com.example.starwhisperserver.model.RegisterRequest;
import com.example.starwhisperserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin_tlk
 * @since 2024-12-12
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    //注册
    @PostMapping("/register")
    public ApiResponse register(@RequestBody RegisterRequest request){
        Map<String,String> response=new HashMap<>();
        //检查非空
        if(request.getUsername().isEmpty()||request.getPassword().isEmpty()){
            return new ApiResponse("用户名和密码不能为空");
        }
        //调用服务层处理数据
        boolean res=userService.register(request.getUsername(),request.getPassword(),request.getCode());
        //成功
        if(res){
            return new ApiResponse("注册成功");
        }
        return new ApiResponse("用户名已存在");
    }
}
