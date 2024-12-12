package com.example.starwhisper_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.starwhisper_server.dao.VerificationCodeMapper;
import com.example.starwhisper_server.model.VerificationCode;
import com.example.starwhisper_server.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class VerificationCodeServiceImpl extends ServiceImpl<VerificationCodeMapper, VerificationCode> implements VerificationCodeService {
    
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendVerificationCode(String email) {
        String code = String.format("%06d", new Random().nextInt(999999));
        Date expires = new Date(System.currentTimeMillis() + 5 * 60 * 1000);

        QueryWrapper<VerificationCode> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        VerificationCode verificationCode = this.getOne(wrapper);

        if (verificationCode == null) {
            verificationCode = new VerificationCode();
            verificationCode.setEmail(email);
        }
        verificationCode.setCode(code);
        verificationCode.setExpires(expires);

        this.saveOrUpdate(verificationCode);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tlk_sure@126.com");
        message.setTo(email);
        message.setSubject("星语小屋 - 验证码");
        message.setText("【星语小屋】您的验证码是: " + code + "，验证码5分钟内有效。");
        mailSender.send(message);
    }

    @Override
    public boolean verifyCode(String email, String code) {
        System.out.println("开始验证验证码，邮箱: " + email + ", 验证码: " + code);

        QueryWrapper<VerificationCode> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        VerificationCode verificationCode = this.getOne(wrapper);

        if (verificationCode == null) {
            System.out.println("验证码记录不存在");
            return false;
        }

        if (new Date().after(verificationCode.getExpires())) {
            System.out.println("验证码已过期，过期时间: " + verificationCode.getExpires());
            this.removeById(verificationCode.getId());
            return false;
        }

        System.out.println("数据库中的验证码: " + verificationCode.getCode());
        System.out.println("用户输入的验证码: " + code);
        return code.equals(verificationCode.getCode());
    }
} 