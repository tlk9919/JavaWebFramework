package com.example.lession17springbootinterceptator.dao;

import com.example.lession17springbootinterceptator.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Your Name
 * @since 2024-12-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
