package com.example.lession16springbootexceptiontemplateengine;

/**
 * @author admin
 * @classnam ExceptionCodeMsgEnum
 * @time 15:42
 * @date 2024/12/3
 */
/**
 * 定义和业务有关的异常信息枚举类
 */
public enum ExceptionCodeMsgEnum {
    //枚举类型不可变
    SERVER_ERROR(50000, "服务器开小差了"),
    CONTENT_NOT_EXIST(10001, "请求内容不存在"),
    USERNAME_NOT_EXIST(10002, "查询内容不存在");

    private Integer code;
    private String message;
    // 构造方法，用于初始化每个枚举常量的 code 和 message， 构造方法的名字与枚举类名必须相同
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
