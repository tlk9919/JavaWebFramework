package com.example.lession14sptingbootmybatisplus1.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lession14sptingbootmybatisplus1.model.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
