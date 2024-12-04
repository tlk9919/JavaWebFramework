package com.starwisper.controller;

import com.starwisper.DTO.LoginRequest;
import com.starwisper.DTO.RegisterRequest;
import com.starwisper.DTO.ResetPasswordRequest;
import com.starwisper.DTO.VerificationCodeRequest;
import com.starwisper.service.UserService;
import com.starwisper.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private VerificationCodeService verificationCodeService;

    // 发送验证码
    @PostMapping("/send-verification-code")
    public ResponseEntity<Map<String, String>> sendVerificationCode(@RequestBody VerificationCodeRequest request) {
        Map<String, String> response = verificationCodeService.sendVerificationCode(request.getEmail());
        return ResponseEntity.ok(response);
    }

    // 验证验证码
    @PostMapping("/verify-code")
    public ResponseEntity<Map<String, String>> verifyCode(@RequestBody VerificationCodeRequest request) {
        Map<String, String> response = verificationCodeService.verifyCode(request.getEmail(), request.getCode());
        return ResponseEntity.ok(response);
    }

    // 重置密码
    @PutMapping("/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestBody ResetPasswordRequest request) {
        Map<String, String> response = userService.resetPassword(request.getEmail(), request.getNewPassword());
        return ResponseEntity.ok(response);
    }

    // 注册
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        Map<String, String> response = userService.register(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    // 登录
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        Map<String, String> response = userService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(response);
    }
}
