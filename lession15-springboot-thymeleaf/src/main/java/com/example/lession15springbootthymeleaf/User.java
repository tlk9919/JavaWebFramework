package com.example.lession15springbootthymeleaf;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author admin
 * @classnam User
 * @time 16:04
 * @date 2024/12/2
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private boolean isVIP;

    private String role;

    private List<String> tags;

    private LocalDate birthDate;

    private LocalTime loginTime;

    private LocalDateTime registrationDateTime;
}
