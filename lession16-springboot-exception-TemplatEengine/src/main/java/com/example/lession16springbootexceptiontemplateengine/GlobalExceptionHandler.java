package com.example.lession16springbootexceptiontemplateengine;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.NoResourceFoundException;
/**
 * @author admin
 * @classnam GlobalExceptionHandler
 * @time 16:13
 * @date 2024/12/3
 */
// Spring 的一个全局异常处理机制的注解
@ControllerAdvice
public class GlobalExceptionHandler {

    //@ExceptionHandler 注解用于指定哪个异常类型会被该方法捕获并处理。
    // 此处的 value = {Exception.class} 表示所有类型为 Exception 或其子类的异常都会被该方法捕获。
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseData exceptionHandler(Exception e) {

        //拦截的异常是自定义异常
        //instanceof 是 Java 中的一个关键字，用来测试对象是否是某个类的实例
        if (e instanceof ServiceException serviceException) {
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