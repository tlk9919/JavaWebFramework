package com.example.lession13springbootmybatis.dao;

import com.example.lession13springbootmybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    /*
     * 添加学生
     * */
    int saveStudent(Student student);

    /*
     * 根据id查询学生
     * */
    Student getStudentByID(int id);

    /*
     * 根据姓名查询学生
     * */
    List<Student> getStudentByName(String name);

    /*
     * 查询所有学生
     * */
    List<Student> getAllStudent();

    /*
     * 根据id修改学生信息
     * */
    int updateStudentById(Student student);

    /*
     * 根据id删除学生
     * */
    int deleteStudentById(int id);
}
