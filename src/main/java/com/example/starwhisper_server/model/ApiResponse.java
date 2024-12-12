package com.example.starwhisper_server.model;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private String token;
    private Object data;

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
} 