package com.example.lession17springbootinterceptator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lession17springbootinterceptator.model.User;
import com.example.lession17springbootinterceptator.dao.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lession17springbootinterceptator.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean doLogin(User user) {
        // 步骤 1: 使用 MyBatis-Plus 查询数据库，查找匹配给定用户名的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User userInDb = this.getOne(queryWrapper);
        System.out.println("userInDb的值: " + userInDb);

        // 步骤 2: 判断数据库中是否存在该用户名对应的用户
        if(userInDb == null || userInDb.getUsername().isEmpty()){
            return false;
        }
        // 步骤 3: 校验用户名和密码是否匹配
        else {
            boolean isUsernameMatch = userInDb.getUsername().equals(user.getUsername());
            boolean isPasswordMatch = Objects.equals(userInDb.getPassword(), user.getPassword());
            return isUsernameMatch && isPasswordMatch;
        }
    }
}