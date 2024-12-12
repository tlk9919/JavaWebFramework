package com.example.starwhisper_server.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String code;
} 