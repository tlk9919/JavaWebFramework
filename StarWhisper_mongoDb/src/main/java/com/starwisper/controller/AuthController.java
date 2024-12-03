package com.starwisper.controller;

import com.starwisper.DTO.VerificationCodeRequest;
import com.starwisper.DTO.ResetPasswordRequest;
import com.starwisper.DTO.LoginRequest;
import com.starwisper.DTO.RegisterRequest;
import com.starwisper.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    // 发送验证码
    @PostMapping("/send-verification-code")
    public ResponseEntity<Map<String, String>> sendVerificationCode(@RequestBody VerificationCodeRequest request) {
        return authService.sendVerificationCode(request.getEmail());
    }

    // 验证验证码
    @PostMapping("/verify-code")
    public ResponseEntity<Map<String, String>>  verifyCode(@RequestBody VerificationCodeRequest request) {
        return authService.verifyCode(request.getEmail(), request.getCode());
    }

    // 重置密码
    @PutMapping("/reset-password")
    public ResponseEntity<Map<String, String>>  resetPassword(@RequestBody ResetPasswordRequest request) {
        return authService.resetPassword(request.getEmail(), request.getCode(),
                request.getNewPassword(), request.getConfirmPassword());
    }

    // 注册
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        return authService.register(request.getUsername(), request.getPassword());
    }

    // 登录
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>>  login(@RequestBody LoginRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }
}
