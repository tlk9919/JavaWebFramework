package com.example.lession16springbootexceptiontemplateengine;

/**
 * @author admin
 * @classnam ServiceException
 * @time 15:46
 * @date 2024/12/3
 */
// 自定义异常类型，在业务逻辑相关的地方抛出这个异常
public class ServiceException extends RuntimeException {

    private final Integer code;
    private final String msg;

    public ServiceException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}