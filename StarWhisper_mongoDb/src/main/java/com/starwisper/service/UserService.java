package com.starwisper.service;

import com.starwisper.model.User;
import com.starwisper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 用户注册
    public Map<String, String> register(String username, String password) {
        Map<String, String> response = new HashMap<>();

        // 查找是否已存在用户名
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            response.put("message", "用户名已存在");
            return response;
        }

        // 新建用户
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // 明文密码
        userRepository.save(newUser);

        response.put("message", "注册成功");
        return response;
    }

    // 用户登录
    public Map<String, String> login(String username, String password) {
        Map<String, String> response = new HashMap<>();

        User user = userRepository.findByUsername(username);
        if (user == null) {
            response.put("message", "用户不存在");
            return response;
        }

        if (!user.getPassword().equals(password)) {
            response.put("message", "密码错误");
            return response;
        }

        response.put("message", "登录成功");
        return response;
    }

    // 重置密码
    public Map<String, String> resetPassword(String email, String newPassword) {
        Map<String, String> response = new HashMap<>();
        User user = userRepository.findByUsername(email);

        if (user == null) {
            response.put("message", "用户不存在");
            return response;
        }

        user.setPassword(newPassword); // 明文密码
        userRepository.save(user);

        response.put("message", "密码重置成功");
        return response;
    }
}
