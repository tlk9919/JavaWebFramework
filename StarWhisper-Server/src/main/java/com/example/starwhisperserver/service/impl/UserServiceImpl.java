package com.example.starwhisperserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.starwhisperserver.model.User;
import com.example.starwhisperserver.dao.UserMapper;
import com.example.starwhisperserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.starwhisperserver.service.IVerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin_tlk
 * @since 2024-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private IVerificationCodeService verificationCodeService;
    //注册
    @Override
  public  boolean register(String username ,String password,String code){
        //验证验证码
        if(!verificationCodeService.verifyCode(username,code)){
            System.out.println("注册时候,验证码验证失败");
            return false;
        }
        //检查用户是否存在
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        //如果已经有返回false
//        User user=this.getOne(queryWrapper);
        if(this.getOne(queryWrapper)!=null){
            return false;
        }
        //不存在就创建新用户
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        //保存到数据库
        return  this.save(user);
    }
    //

}
