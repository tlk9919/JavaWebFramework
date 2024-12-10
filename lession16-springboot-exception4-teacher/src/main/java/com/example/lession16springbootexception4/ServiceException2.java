package com.example.lession16springbootexception4;

public class ServiceException2 extends RuntimeException{

    private final Integer code;
    private final String msg;

    public ServiceException2(Integer code, String msg) {
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
