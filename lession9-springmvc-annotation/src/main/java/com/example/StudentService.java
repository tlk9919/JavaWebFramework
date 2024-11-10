package com.example;

import java.util.List;

public interface StudentService {
    public int addStudent(Student student);

    public Student getStudentById(int id);

    public List<Student> getAllStudents();

    public  int updateStudent(Student student);

    public   int deleteStudentById(int id);

}
