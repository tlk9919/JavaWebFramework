package com.example.starwhisper_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.starwhisper_server.dao.UserMapper;
import com.example.starwhisper_server.model.User;
import com.example.starwhisper_server.service.UserService;
import com.example.starwhisper_server.service.VerificationCodeService;
import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    private static final SecretKey JWT_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    
    @Value("${jwt.expiration:3600000}")
    private Long jwtExpiration;

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Override
    public boolean register(String username, String password, String code) {
        System.out.println("开始注册，用户名: " + username + ", 验证码: " + code);
        
        // 先验证验证码
        if (!verificationCodeService.verifyCode(username, code)) {
            System.out.println("验证码验证失败");
            return false;
        }

        // 再检查用户名是否已存在
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("username", username);
        if (this.getOne(userWrapper) != null) {
            System.out.println("用户名已存在");
            return false;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean result = this.save(user);
        System.out.println("注册结果: " + result);
        return result;
    }

    @Override
    public String login(String username, String password) {
        try {
            System.out.println("开始登录，用户名: " + username + ", 密码: " + password);
            
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username)
                    .eq("password", password);
            
            System.out.println("SQL条件: " + wrapper.getSqlSegment());
            
            User user = this.getOne(wrapper);
            System.out.println("查询结果: " + user);
            
            if (user == null) {
                System.out.println("用户为空，返回null");
                return null;
            }

            try {
                String token = Jwts.builder()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                        .signWith(JWT_KEY)
                        .compact();
                System.out.println("生成token成功: " + token);
                return token;
            } catch (Exception e) {
                System.out.println("生成token失败: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            System.out.println("登录过程异常: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean resetPassword(String email, String code, String newPassword) {
        System.out.println("开始重置密码，邮箱: " + email + ", 验证码: " + code + ", 新密码: " + newPassword);

        // 先验证验证码
        if (!verificationCodeService.verifyCode(email, code)) {
            System.out.println("验证码验证失败");
            return false;
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", email);
        
        User user = this.getOne(wrapper);
        if (user == null) {
            System.out.println("用户不存在");
            return false;
        }

        user.setPassword(newPassword);
        boolean result = this.updateById(user);
        System.out.println("密码修改结果: " + result);
        return result;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("开始查询所有用户");
        List<User> users = this.list();  // 使用MyBatis-Plus提供的list()方法
        System.out.println("查询到的用户数量: " + users.size());
        return users;
    }
} 