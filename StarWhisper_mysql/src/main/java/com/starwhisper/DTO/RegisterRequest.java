package com.starwhisper.DTO;

/**
 * @author admin
 * @classnam RegisterRequest
 * @time 19:35
 * @date 2024/12/3
 */


import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
