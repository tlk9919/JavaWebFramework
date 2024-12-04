package com.starwhisper.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 主键自增
    private Long id;  // 将 String 改为 Long

    @Column(nullable = false, unique = true)  // 确保用户名唯一且不能为空
    private String username;

    @Column(nullable = false)
    private String password;
}