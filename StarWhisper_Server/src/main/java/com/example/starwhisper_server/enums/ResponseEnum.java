package com.example.starwhisper_server.enums;

public enum ResponseEnum {
    // 通用
    SUCCESS(200, "操作成功"),
    ERROR(500, "操作失败"),
    
    // 用户相关
    USERNAME_PASSWORD_EMPTY(1001, "用户名和密码不能为空"),
    USER_ALREADY_EXISTS(1002, "用户名已存在"),
    LOGIN_SUCCESS(1003, "登录成功"),
    LOGIN_FAILED(1004, "用户名或密码错误"),
    
    // 密码相关
    PASSWORD_RESET_SUCCESS(2001, "密码修改成功"),
    PASSWORD_RESET_FAILED(2002, "密码重置失败"),
    
    // 查询相关
    QUERY_SUCCESS(3001, "查询成功"),
    QUERY_FAILED(3002, "查询失败");

    private final int code;
    private final String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
} 