package com.example.starwhisper_server.service;

import com.example.starwhisper_server.model.User;
import java.util.List;

public interface UserService {
    boolean register(String username, String password, String code);
    String login(String username, String password);
    boolean resetPassword(String email, String code, String newPassword);
    List<User> getAllUsers();
} 