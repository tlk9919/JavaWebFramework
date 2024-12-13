package com.example.starwhisperserver.model;

import lombok.Data;

/**
 * @author admin
 * @classnam ApiResponse
 * @time 22:26
 * @date 2024/12/12
 */
//统一返回格式
    @Data
public class ApiResponse {
    private String message;
    private String token;

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }
}
