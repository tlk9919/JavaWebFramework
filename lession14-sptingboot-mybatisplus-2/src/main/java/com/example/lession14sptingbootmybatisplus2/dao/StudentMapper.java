package com.example.lession14sptingbootmybatisplus2.dao;

import com.example.lession14sptingbootmybatisplus2.model.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Your Name
 * @since 2024-11-26
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
