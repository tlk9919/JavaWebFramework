package com.starwisper.DTO;

/**
 * @author admin
 * @classnam LoginRequest
 * @time 19:35
 * @date 2024/12/3
 */

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
