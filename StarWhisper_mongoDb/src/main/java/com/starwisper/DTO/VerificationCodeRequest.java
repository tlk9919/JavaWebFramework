package com.starwisper.DTO;

import lombok.Data;

/**
 * @author admin
 * @classnam VerificationCodeRequest
 * @time 17:36
 * @date 2024/12/3
 */
@Data
public class VerificationCodeRequest {
    private String email;  // email 参数
    private String code;
}