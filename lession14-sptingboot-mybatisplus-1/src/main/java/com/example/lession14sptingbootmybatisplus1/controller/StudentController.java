package com.example.lession14sptingbootmybatisplus1.controller;

import com.example.lession14sptingbootmybatisplus1.model.Student;
import com.example.lession14sptingbootmybatisplus1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 * @classnam StudentController
 * @time 17:23
 * @date 2024/11/26
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public String register(@RequestBody Student student){
        System.out.println(student);
        int res = studentService.addStudent(student);
        if(1==res){
            return "register success!";
        }else {
            return "register failed!";
        }
    }
    @GetMapping("/searchById")
    public Student searchById(@RequestParam("id") int id){
        System.out.println(id);
        Student student = studentService.getStudentByID(id);
        return student;
    }
    @GetMapping("/searchByName")
    public List<Student> searchByName(@RequestParam("name") String name){
        System.out.println(name);
        List<Student> studentList= studentService.getStudentByNameFuzzy(name);
        System.out.println(studentList);
        return studentList;
    }

    @GetMapping("/all")
    public List<Student> searchAll(){
        List<Student> studentList= studentService.getAllStudent();
        return  studentList;
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student){
        System.out.println(student);
        int res=studentService.updateStudentById(student);
        if (1==res){
            return studentService.getStudentByID(student.getId()).toString();
        }else {
            return "edit failed!";
        }
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam("id") int id){
        System.out.println(id);
        int res = studentService.deleteStudentById(id);
        if(1==res){
            return "delete success!";
        }else {
            return "delete failed!";
        }
    }

}
