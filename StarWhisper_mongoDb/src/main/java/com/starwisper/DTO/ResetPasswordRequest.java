package com.starwisper.DTO;

/**
 * @author admin
 * @classnam ResetPasswordRequest
 * @time 19:35
 * @date 2024/12/3
 */


import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String email;
    private String code;
    private String newPassword;
    private String confirmPassword;
}
