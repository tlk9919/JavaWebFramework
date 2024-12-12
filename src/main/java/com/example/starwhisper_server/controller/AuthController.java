package com.example.starwhisper_server.controller;


import com.example.starwhisper_server.service.UserService;
import com.example.starwhisper_server.service.VerificationCodeService;
import com.example.starwhisper_server.model.User;
import com.example.starwhisper_server.model.VerificationCode;
import com.example.starwhisper_server.model.ApiResponse;
import com.example.starwhisper_server.model.VerifyCodeRequest;
import com.example.starwhisper_server.model.RegisterRequest;
import com.example.starwhisper_server.model.ResetPasswordRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody RegisterRequest request) {
        System.out.println("接收到的注册请求数据: " + request);  // 添加日志
        
        // 验证数据是否为空
        if (request.getUsername() == null || request.getUsername().trim().isEmpty() ||
            request.getPassword() == null || request.getPassword().trim().isEmpty() ||
            request.getCode() == null || request.getCode().trim().isEmpty()) {
            return new ApiResponse("所有字段都是必填项");
        }

        if (userService.register(request.getUsername(), request.getPassword(), request.getCode())) {
            return new ApiResponse("注册成功");
        }
        return new ApiResponse("用户名已存在");
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody User user) {
        String token = userService.login(user.getUsername(), user.getPassword());
        if (token != null) {
            return new ApiResponse("登录成功", token);
        }
        return new ApiResponse("用户名或密码错误");
    }

    @PostMapping("/send-verification-code")
    public ApiResponse sendVerificationCode(@RequestBody VerificationCode verificationCode) {
        try {
            verificationCodeService.sendVerificationCode(verificationCode.getEmail());
            return new ApiResponse("验证码发送成功");
        } catch (Exception e) {
            return new ApiResponse("验证码发送失败");
        }
    }

    @PostMapping("/verify-code")
    public ApiResponse verifyCode(@RequestBody VerifyCodeRequest request) {
        if (verificationCodeService.verifyCode(request.getEmail(), request.getCode())) {
            return new ApiResponse("验证码验证成功");
        }
        return new ApiResponse("验证码错误");
    }

    @PutMapping("/reset-password")
    public ApiResponse resetPassword(@RequestBody ResetPasswordRequest request) {
        System.out.println("接收到的原始请求数据: " + request);
        System.out.println("email: " + request.getEmail());
        System.out.println("newPassword: " + request.getNewPassword());
        System.out.println("code: " + request.getCode());

        if (request.getEmail() == null || request.getEmail().trim().isEmpty() ||
            request.getCode() == null || request.getCode().trim().isEmpty() ||
            request.getNewPassword() == null || request.getNewPassword().trim().isEmpty()) {
            System.out.println("参数校验失败");  // 添加日志
            return new ApiResponse("所有字段都是必填项");
        }

        if (userService.resetPassword(request.getEmail(), request.getCode(), request.getNewPassword())) {
            return new ApiResponse("密码修改成功");
        }
        return new ApiResponse("修改密码时出错");
    }

    @GetMapping("/users")
    public ApiResponse getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return new ApiResponse("查询成功", users);  
        } catch (Exception e) {
            System.out.println("查询用户列表失败: " + e.getMessage());
            return new ApiResponse("查询失败");
        }
    }
} 