package com.example.lession16springbootexception4;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseData exceptionHandler(Exception e){

        //拦截的异常是自定义异常
        if (e instanceof ServiceException serviceException) {
            return ResponseData.error(serviceException.getCode(),serviceException.getMsg());
        }

        //拦截的异常是自定义异常2
        if (e instanceof ServiceException2 serviceException) {
            return ResponseData.error(serviceException.getCode(),serviceException.getMsg());
        }

        //拦截的异常是程序运行中可能出现的异常
        if (e instanceof NoResourceFoundException){
            return ResponseData.error(ExceptionCodeMsgEnum.CONTENT_NOT_EXIST);
        }

        //未知异常
        return ResponseData.error(ExceptionCodeMsgEnum.SERVER_ERROR.getCode(),ExceptionCodeMsgEnum.SERVER_ERROR.getMessage());

    }
}
