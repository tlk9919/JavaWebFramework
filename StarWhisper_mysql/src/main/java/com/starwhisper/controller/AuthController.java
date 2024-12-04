package com.starwhisper.controller;
import com.starwhisper.DTO.LoginRequest;
import com.starwhisper.DTO.RegisterRequest;
import com.starwhisper.DTO.ResetPasswordRequest;
import com.starwhisper.DTO.VerificationCodeRequest;
import com.starwhisper.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
