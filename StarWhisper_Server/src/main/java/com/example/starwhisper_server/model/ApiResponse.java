package com.example.starwhisper_server.model;

import com.example.starwhisper_server.enums.ResponseEnum;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public ApiResponse(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public ApiResponse(ResponseEnum responseEnum, T data) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResponseEnum.SUCCESS, data);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(ResponseEnum.SUCCESS);
    }

    public static <T> ApiResponse<T> error() {
        return new ApiResponse<>(ResponseEnum.ERROR);
    }

    public static <T> ApiResponse<T> error(ResponseEnum responseEnum) {
        return new ApiResponse<>(responseEnum);
    }
} 