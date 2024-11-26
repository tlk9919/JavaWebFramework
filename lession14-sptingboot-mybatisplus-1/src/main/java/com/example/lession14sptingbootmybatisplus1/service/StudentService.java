package com.example.lession14sptingbootmybatisplus1.service;

import com.example.lession14sptingbootmybatisplus1.model.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);


    Student getStudentByID(int id);

    List<Student> getStudentByNameFuzzy(String name);

    List<Student> getStudentByName(String name);


    List<Student> getAllStudent();


    int updateStudentById(Student student);


    int deleteStudentById(int id);
}
