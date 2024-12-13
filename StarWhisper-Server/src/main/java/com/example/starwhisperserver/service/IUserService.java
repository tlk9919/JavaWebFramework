package com.example.starwhisperserver.service;

import com.example.starwhisperserver.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin_tlk
 * @since 2024-12-12
 */
public interface IUserService extends IService<User> {
    //注册re
    boolean register(String username ,String password,String code);
    //登录
    String login(String username ,String password);
}
