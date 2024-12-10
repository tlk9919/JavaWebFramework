package com.example.lession16springbootexception4;


public enum ExceptionCodeMsgEnum {

    SERVER_ERROR(50000, "服务器开小差了"),
    CONTENT_NOT_EXIST(10001, "请求内容不存在"),
    USERNAME_NOT_EXIST(10002, "查询内容不存在");

    private Integer code;

    private String message;

    ExceptionCodeMsgEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
