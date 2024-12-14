package com.example.starwhisper_server.controller;


import com.example.starwhisper_server.service.UserService;
import com.example.starwhisper_server.service.VerificationCodeService;
import com.example.starwhisper_server.model.User;
import com.example.starwhisper_server.model.VerificationCode;
import com.example.starwhisper_server.model.ApiResponse;
import com.example.starwhisper_server.model.VerifyCodeRequest;
import com.example.starwhisper_server.model.RegisterRequest;
import com.example.starwhisper_server.model.ResetPasswordRequest;
import com.example.starwhisper_server.enums.ResponseEnum;

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
    public ApiResponse<String> register(@RequestBody RegisterRequest request) {
        if (request.getUsername().isEmpty() || request.getPassword().isEmpty()) {
            return new ApiResponse<>(ResponseEnum.USERNAME_PASSWORD_EMPTY);
        }
        
        boolean res = userService.register(request.getUsername(), request.getPassword(), request.getCode());
        return res ? 
            new ApiResponse<>(ResponseEnum.SUCCESS) : 
            new ApiResponse<>(ResponseEnum.USER_ALREADY_EXISTS);
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return new ApiResponse<>(ResponseEnum.USERNAME_PASSWORD_EMPTY);
        }
        
        String token = userService.login(user.getUsername(), user.getPassword());
        return token != null ? 
            new ApiResponse<>(ResponseEnum.LOGIN_SUCCESS, token) : 
            new ApiResponse<>(ResponseEnum.LOGIN_FAILED);
    }

    @PostMapping("/send-verification-code")
    public ApiResponse<String> sendVerificationCode(@RequestBody VerificationCode verificationCode) {
        try {
            verificationCodeService.sendVerificationCode(verificationCode.getEmail());
            return new ApiResponse<>(ResponseEnum.SUCCESS);
        } catch (Exception e) {
            return new ApiResponse<>(ResponseEnum.ERROR);
        }
    }

    @PostMapping("/verify-code")
    public ApiResponse<String> verifyCode(@RequestBody VerifyCodeRequest request) {
        if (verificationCodeService.verifyCode(request.getEmail(), request.getCode())) {
            return new ApiResponse<>(ResponseEnum.SUCCESS);
        }
        return new ApiResponse<>(ResponseEnum.ERROR);
    }

    @PutMapping("/reset-password")
    public ApiResponse<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        if (request.getEmail() == null || request.getNewPassword() == null) {
            return new ApiResponse<>(ResponseEnum.USERNAME_PASSWORD_EMPTY);
        }
        
        if (userService.resetPassword(request.getEmail(), request.getCode(), request.getNewPassword())) {
            return new ApiResponse<>(ResponseEnum.PASSWORD_RESET_SUCCESS);
        }
        return new ApiResponse<>(ResponseEnum.PASSWORD_RESET_FAILED);
    }

    @GetMapping("/users")
    public ApiResponse<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            if (users != null && !users.isEmpty()) {
                return new ApiResponse<>(ResponseEnum.QUERY_SUCCESS, users);
            }
            return new ApiResponse<>(ResponseEnum.QUERY_FAILED);
        } catch (Exception e) {
            System.out.println("查询用户列表失败: " + e.getMessage());
            return new ApiResponse<>(ResponseEnum.QUERY_FAILED);
        }
    }
} 