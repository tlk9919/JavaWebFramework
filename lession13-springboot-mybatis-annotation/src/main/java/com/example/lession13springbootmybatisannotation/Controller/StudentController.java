package com.example.lession13springbootmybatisannotation.Controller;

import com.example.lession13springbootmybatisannotation.model.Student;
import com.example.lession13springbootmybatisannotation.servers.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 * @classnam StudentController
 * @time 17:53
 * @date 2024/11/19
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public String register(@RequestBody Student student){

        System.out.println(student);
        int res= studentService.addStudent(student);//返回一个1

        if(1==res){

            return "注册成功";
        }
        else {
            return "注册失败";
        }
    }
    @GetMapping("/searchById")
    public Student searchById(@RequestParam("id") int id){
        System.out.println(id);
        Student student=studentService.getStudentByID(id);
        return student;
    }

    @GetMapping("/searchByName")
    public List<Student> searchByName(@RequestParam("name") String name){
        System.out.println(name);
        List<Student> studentList=studentService.getStudentByName(name);
        return studentList;

    }

    @GetMapping("/All")
    public  List<Student> searchAll(){
        List<Student> studentList=studentService.getAllStudent();
        return studentList;
    }

    @PutMapping("/update")
    public String updateStudent(Student student){
        System.out.println(student);
        int res=studentService.updateStudentById(student);
        if(1==res){
            return "编辑成功";
        }
        else {
            return "编辑失败";
        }

    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam("id") int id){
        System.out.println(id);
        int res=studentService.deleteStudentById(id);
        if(1==res){
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }

}
