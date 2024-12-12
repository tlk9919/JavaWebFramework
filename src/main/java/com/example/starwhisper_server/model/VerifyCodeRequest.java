package com.example.starwhisper_server.model;

import lombok.Data;

@Data
public class VerifyCodeRequest {
    private String email;
    private String code;
} 