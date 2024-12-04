package com.starwhisper.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 使用自增策略生成主键
    private Long id;  // MySQL 中的 id 通常使用 Long 类型

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String code;

    @Temporal(TemporalType.TIMESTAMP)  // 显示指定为时间戳类型
    @Column(nullable = false)
    private Date expires;
}
