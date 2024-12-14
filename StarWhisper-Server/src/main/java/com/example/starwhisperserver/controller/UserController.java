package com.example.starwhisperserver.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.starwhisperserver.model.ApiResponse;
import com.example.starwhisperserver.model.RegisterRequest;
import com.example.starwhisperserver.model.User;
import com.example.starwhisperserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //登录
    @PostMapping("/login")
    public  ApiResponse  login(@RequestBody User user){
        //检查非空
        String username=user.getUsername();
        String password=user.getPassword();
        if(username==null||password==null){
            return  new ApiResponse("请输入账号名或密码");
        }
        //调用服务处理数据
        String token= userService.login(username,password);

        //成功
        if (token != null) {
            return new ApiResponse("登录成功", token);
        }
        return new ApiResponse("用户名或密码错误");
    }
    //重置密码
    @PutMapping("/reset-password")
    public Map<String,String> resetPassword(@RequestBody Map<String ,String> request){//RegisterRequest 含有相应字段
        Map<String,String> response=new HashMap<>();
        //非空校验
        System.out.println("接收到的重置密码请求: " + request);
        String username=request.get("email");
        String newPassword=request.get("newPassword");
        String confirmPassword=request.get("confirmPassword");
        String code=request.get("code");

        if(username==null||newPassword ==null) {
            response.put("message", "请输入密码或用户名");
            return response;
        }
        //调用服务
       boolean result= userService.resetPassword(username,newPassword,code,confirmPassword);
        if(result){
            response.put("message", "密码修改成功");
            return response;
        }
        response.put("message", "密码重置失败");
        return response;
    }
}
