package com.example.lession16springbootexceptiontemplateengine;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @classnam HelloController
 * @time 16:30
 * @date 2024/12/3
 */
@RestController
public class HelloController {

    @PostMapping("/exception")
    public ResponseData testException(@RequestParam(value = "error", defaultValue = "ok") String error){
        //模拟请求成功，构造一个成功的ResponseData返回
        if("ok".equals(error)){
            return ResponseData.sucecss("successful");
        }

        // 模拟请求导致了服务发生了我们自定义的异常
        if("1".equals(error)){
            throw new ServiceException(ExceptionCodeMsgEnum.CONTENT_NOT_EXIST.getCode(),ExceptionCodeMsgEnum.CONTENT_NOT_EXIST.getMessage());
        }
        // 模拟请求导致了服务发生了事先未知的异常
        if("0".equals(error)){
            int i = 1/0;
        }
        return ResponseData.sucecss("request success");
    }
}