package com.example.starwhisperserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.starwhisperserver.model.ApiResponse;
import com.example.starwhisperserver.model.VerificationCode;
import com.example.starwhisperserver.service.IVerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin_tlk
 * @since 2024-12-12
 */
@RestController
public class VerificationCodeController {

    @Autowired
    private IVerificationCodeService verificationCodeService;
    //发送验证码
    @PostMapping("/send-verification-code")
    public ApiResponse sendVerificationCode(@RequestBody VerificationCode verificationCode){

        //调用服务层
      boolean res=  verificationCodeService.sendVerificationCode( verificationCode.getEmail());
      if (res){
          return new ApiResponse("验证码发送成功");
      }
        return new ApiResponse("验证码发送失败");
    }
    //验证验证码
    @PostMapping("/verify-code")
    public ApiResponse verifyCode(@RequestBody VerificationCode verificationCode){
        String email= verificationCode.getEmail();
        String code=verificationCode.getCode();
//        Map<String, String> response = new HashMap<>();
    //调用服务层，没有,创建验证码记录
        QueryWrapper<VerificationCode> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("email",email);
        VerificationCode existingVerificationCode=verificationCodeService.getOne(queryWrapper);
        // 判断验证码是否存在
        if (existingVerificationCode == null) {
            return new ApiResponse("验证码不存在");
        }

        // 判断验证码是否过期
        if (new Date().after(existingVerificationCode.getExpires())) {
            return new ApiResponse("验证码已过期");
        }

        // 判断验证码是否正确
        if (!code.equals(existingVerificationCode.getCode())) {
            return new ApiResponse("验证码错误");
        }
        return new ApiResponse("验证码验证成功");
    }
}