package com.example.lession16springbootexception.dao;

import com.example.lession16springbootexception.model.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Your Name
 * @since 2024-12-03
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
