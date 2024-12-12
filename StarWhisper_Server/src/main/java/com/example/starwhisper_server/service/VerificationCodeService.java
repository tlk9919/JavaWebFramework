package com.example.starwhisper_server.service;

public interface VerificationCodeService {
    void sendVerificationCode(String email);
    boolean verifyCode(String email, String code);
} 