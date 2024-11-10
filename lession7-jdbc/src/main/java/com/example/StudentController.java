package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author admin
 * @classnam StudentController
 * @time 17:37
 * @date 2024/10/21
 */
@Controller
public class StudentController {
    @Autowired
    private  StudentService studentService;
    public void addStudent(Student student){
        studentService.addStudent(student);
    }
    public Student getStudentById ( int id ){
        return studentService.getStudentById(id);
    }
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    public  void updateStudent (Student student){
        studentService.updateStudent(student);
    }
    public  void deleteStudentById(int id){
        studentService.deleteStudentById(id);
    }
}
