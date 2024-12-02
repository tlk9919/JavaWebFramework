package com.example.lession15springbootthymeleaf_case.dao;

import com.example.lession15springbootthymeleaf_case.model.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin_tlk
 * @since 2024-12-02
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
