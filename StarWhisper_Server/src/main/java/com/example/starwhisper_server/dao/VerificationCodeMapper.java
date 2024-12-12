package com.example.starwhisper_server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.starwhisper_server.model.VerificationCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VerificationCodeMapper extends BaseMapper<VerificationCode> {
} 