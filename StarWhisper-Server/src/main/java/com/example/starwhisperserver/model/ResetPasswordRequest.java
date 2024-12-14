package com.example.starwhisperserver.model;

import lombok.Data;

/**
 * @author admin
 * @classnam ResetPasswordRequest
 * @time 13:47
 * @date 2024/12/14
 */
@Data
public class ResetPasswordRequest {
    private String email;        // 用户邮箱
    private String newPassword;
    private String confirmPassword;// 新密码
    private String code;
}