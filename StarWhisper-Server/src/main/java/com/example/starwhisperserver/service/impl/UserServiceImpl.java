package com.example.starwhisperserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.starwhisperserver.model.User;
import com.example.starwhisperserver.dao.UserMapper;
import com.example.starwhisperserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.starwhisperserver.service.IVerificationCodeService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

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
    //生成一个符合 HS256 算法要求的密钥。
    private static final SecretKey JWT_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    @Value("${jwt.expiration:3600000}")  // 默认1小时
    private Long jwtExpiration;

    //注册
    @Override
  public  boolean register(String username ,String password,String code){
        //验证验证码
        if(!verificationCodeService.verifyCode(username,code)){
            System.out.println("服务层：注册时候,验证码验证失败");
            return false;
        }
        //检查用户是否存在
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        //如果已经有返回false
//        User user=this.getOne(queryWrapper);
        if(this.getOne(queryWrapper)!=null){
            System.out.println("服务层：用户名有已经存在");
            return false;
        }
        //不存在就创建新用户
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        //保存到数据库
        return  this.save(user);
    }
    //登录
    @Override
    public String login (String username ,String password){
        //查找用户名是否存在
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //验证账号密码
        queryWrapper.eq("username",username).eq("password",password);
        User user=this.getOne(queryWrapper);
        //用户不存在
        if(user==null){
            System.out.println("服务层：用户名不存在");
            return  null;
        }
        //生成token
        String token= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date()) // 设置 JWT 的签发时间
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpiration))
                .signWith(JWT_KEY)  // 使用密钥进行签名
                .compact();  // 最终生成 JWT 字符串
        return token;
    }
    //忘记密码
@Override
   public  boolean resetPassword(String email, String code, String newPassword ,String confirmPassword){
        //校验验证码
    if(verificationCodeService.verifyCode(email,code)){

        return false;
    }
    //校验用户名是否存在
    QueryWrapper<User> queryWrapper=new QueryWrapper<>();
    queryWrapper.eq("username",email);
    //密码修改
    User user=this.getOne(queryWrapper);
    if(user==null){
        System.out.println("服务层：用户名不存在");
        return false;
    }
    //执行修改密码
    user.setPassword(newPassword);
    boolean result=this.updateById(user);//有主键的更新方法
    return result;
}
}
