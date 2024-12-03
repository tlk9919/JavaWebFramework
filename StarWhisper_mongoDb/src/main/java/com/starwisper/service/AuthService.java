package com.starwisper.service;


import com.starwisper.model.User;
import com.starwisper.model.VerificationCode;
import com.starwisper.repository.UserRepository;
import com.starwisper.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    // 发送验证码
    public ResponseEntity<Map<String, String>>  sendVerificationCode(String email) {
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
        // 创建一个标准的响应对象
        Map<String, String> response = new HashMap<>();
        response.put("message", "验证码发送成功");

        // 返回包含 message 字段的 JSON 响应
        return ResponseEntity.ok(response);
    }

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

    public ResponseEntity<Map<String, String>> verifyCode(String email, String code) {
        VerificationCode verificationRecord = verificationCodeRepository.findByEmail(email);

        Map<String, String> response = new HashMap<>();

        if (verificationRecord == null) {
            response.put("message", "验证码不存在");
            return ResponseEntity.badRequest().body(response);
        }

        System.out.println("数据库验证码: " + verificationRecord.getCode());  // 打印数据库中的验证码
        System.out.println("前端验证码: " + code);  // 打印前端传递的验证码

        if (new Date().after(verificationRecord.getExpires())) {
            verificationCodeRepository.delete(verificationRecord);
            response.put("message", "验证码已过期");
            return ResponseEntity.badRequest().body(response);
        }

        if (verificationRecord.getCode().equals(code)) {
            response.put("message", "验证码验证成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "验证码错误");
            return ResponseEntity.badRequest().body(response);
        }
    }



    // 修改密码
    public ResponseEntity<Map<String, String>> resetPassword(String email, String code, String newPassword, String confirmPassword) {
        Map<String, String> response = new HashMap<>();

        if (!newPassword.equals(confirmPassword)) {
            response.put("message", "两次输入的密码不一致");
            return ResponseEntity.badRequest().body(response);
        }

        VerificationCode verificationRecord = verificationCodeRepository.findByEmail(email);
        if (verificationRecord == null) {
            response.put("message", "验证码不存在");
            return ResponseEntity.badRequest().body(response);
        }

        if (new Date().after(verificationRecord.getExpires())) {
            response.put("message", "验证码已过期");
            return ResponseEntity.badRequest().body(response);
        }

        if (!verificationRecord.getCode().equals(code)) {
            response.put("message", "验证码错误");
            return ResponseEntity.badRequest().body(response);
        }

        User user = userRepository.findByUsername(email);
        if (user == null) {
            response.put("message", "用户不存在");
            return ResponseEntity.badRequest().body(response);
        }

        user.setPassword(newPassword);
        userRepository.save(user);

        verificationCodeRepository.delete(verificationRecord);
        response.put("message", "密码修改成功");
        return ResponseEntity.ok(response);
    }
    //注册
    public ResponseEntity<Map<String, String>> register(@RequestParam String username, @RequestParam String password) {
        // 打印请求参数
        System.out.println("注册请求参数: " + "username=" + username + ", password=" + password);

        Map<String, String> response = new HashMap<>();

        // 查找是否已存在用户名
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            System.out.println("用户名已存在: " + username);  // 添加日志
            response.put("message", "用户名已存在");
            // 打印响应内容
            System.out.println("响应内容message: " + response.get("message"));
            return ResponseEntity.badRequest().body(response);  // 返回 400 错误响应
        }

        // 新建用户
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userRepository.save(newUser);

        // 返回注册成功消息
        response.put("message", "注册成功");
        return ResponseEntity.ok(response);  // 返回 200 正常响应
    }





    // 用户登录
    public ResponseEntity<Map<String, String>> login(@RequestParam String username, @RequestParam String password) {
        Map<String, String> response = new HashMap<>();

        // 查找用户
        User user = userRepository.findByUsername(username);
        if (user == null) {
            response.put("message", "用户不存在");
            return ResponseEntity.badRequest().body(response);  // 用户不存在，返回 400 错误
        }

        // 检查密码
        if (!user.getPassword().equals(password)) {
            response.put("message", "密码错误");
            return ResponseEntity.badRequest().body(response);  // 密码错误，返回 400 错误
        }

        // 登录成功
        response.put("message", "登录成功");
        return ResponseEntity.ok(response);  // 返回 200 正常响应
    }



}
