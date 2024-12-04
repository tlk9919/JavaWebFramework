package com.starwisper.service;

import com.starwisper.model.VerificationCode;
import com.starwisper.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class VerificationCodeService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    // 生成并发送验证码
    public Map<String, String> sendVerificationCode(String email) {
        Random random = new Random();
        String code = String.format("%06d", random.nextInt(999999));
        Date expires = new Date(System.currentTimeMillis() + 300000); // 5分钟

        // 查找现有的验证码记录
        VerificationCode existingCode = verificationCodeRepository.findByEmail(email);
        if (existingCode != null) {
            existingCode.setCode(code);
            existingCode.setExpires(expires);
            verificationCodeRepository.save(existingCode);
        } else {
            VerificationCode newCode = new VerificationCode();
            newCode.setEmail(email);
            newCode.setCode(code);
            newCode.setExpires(expires);
            verificationCodeRepository.save(newCode);
        }

        // 发送邮件
        sendEmail(email, code);

        // 返回成功响应
        Map<String, String> response = new HashMap<>();
        response.put("message", "验证码发送成功");
        return response;
    }

    // 验证验证码
    public Map<String, String> verifyCode(String email, String code) {
        VerificationCode verificationRecord = verificationCodeRepository.findByEmail(email);
        Map<String, String> response = new HashMap<>();

        if (verificationRecord == null) {
            response.put("message", "验证码不存在");
        } else if (new Date().after(verificationRecord.getExpires())) {
            verificationCodeRepository.delete(verificationRecord);
            response.put("message", "验证码已过期");
        } else if (verificationRecord.getCode().equals(code)) {
            response.put("message", "验证码验证成功");
        } else {
            response.put("message", "验证码错误");
        }
        return response;
    }

    // 发送邮件
    private void sendEmail(String to, String code) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("tlk_sure@126.com");
            helper.setTo(to);
            helper.setSubject("星语小屋");
            helper.setText("【星语小屋】您的验证码是: " + code + "，验证码5分钟内有效。");

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("邮件发送失败", e);
        }
    }
}
