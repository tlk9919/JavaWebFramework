package com.example.lession13springbootmybatisannotation.servers;

import com.example.lession13springbootmybatisannotation.model.Student;

import java.util.List;

/**
 * @author admin
 * @classnam StudentService
 * @time 17:36
 * @date 2024/11/19
 */
public interface StudentService {

    int addStudent(Student student);

    Student getStudentByID(int id);

    List<Student>getStudentByName(String name);

    List<Student> getAllStudent();

    int updateStudentById(Student student);

    int deleteStudentById(int id);
}
