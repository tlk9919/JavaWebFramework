package com.example.lession16springbootexception4;

import lombok.Data;

@Data
public class ResponseData {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    public ResponseData(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /*
     * 请求成功时返回，固定状态码和描述信息
     * */
    public static ResponseData sucecss(Object data) {
        ResponseData resp = new ResponseData(200, "success", data);
        return resp;
    }

    /*
     * 请求成功时返回，固定状态码
     * */
    public static ResponseData sucecss(String msg, Object data) {
        ResponseData resp = new ResponseData(200, msg, data);
        return resp;
    }

    /*
     * 请求错误时返回，返回的错误状态码和错误信息必须是自定义的异常枚举类中的信息
     * */
    public static ResponseData error(ExceptionCodeMsgEnum exceptionCodeMsgEnum) {
        ResponseData resp = new ResponseData(exceptionCodeMsgEnum.getCode(), exceptionCodeMsgEnum.getMessage(), null);
        return resp;
    }

    /*
     * 请求错误时返回
     * */
    public static ResponseData error(int code, String msg) {
        ResponseData resp = new ResponseData(code, msg, null);
        return resp;
    }
}

