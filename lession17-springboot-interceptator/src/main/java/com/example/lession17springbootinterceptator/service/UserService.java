package com.example.lession17springbootinterceptator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lession17springbootinterceptator.model.User;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @classnam UserService
 * @time 17:07
 * @date 2024/12/10
 */
@Service
public interface UserService<U> extends IService<User> {
    public boolean doLogin(User user);
}
