package com.example.lession14sptingbootmybatisplus2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lession14sptingbootmybatisplus2.model.Student;
import com.example.lession14sptingbootmybatisplus2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Your Name
 * @since 2024-11-26
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/searchById")
    public Student getByID(@RequestParam("id") int id){
        System.out.println(id);
       Student student =studentService.getById(id);
        System.out.println(student);
        return student;
    }

    @GetMapping("/searchByName")
    public List<Student> getByName(@RequestParam("name") String name){
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sname",name);
        List<Student> studentList=studentService.list(queryWrapper);
        return  studentList;
    }
    @GetMapping("/searchByNameFuzzy")
    public List<Student> getByNameFuzzy(@RequestParam("name") String name){
        // 模糊查询
        QueryWrapper<Student> queryWrapper =new QueryWrapper<>();
        queryWrapper.like("sname",name);
        List<Student> studentList=studentService.list(queryWrapper);
        return  studentList;
    }
    @GetMapping("/all")
    public List<Student> searchAll(){
        List<Student> studentList=studentService.list();
        System.out.println(studentList);
        return studentList;
    }

    @PostMapping("/register")
    public String register(@RequestBody Student student){
       Boolean flag= studentService.save(student);
        System.out.println("添加成功？：\t" + flag);
        System.out.println("查询所有：\n" + studentService.list());
        if (flag) {
            return "注册成功！";
        } else {
            return "注册失败！";
        }
    }


    @PutMapping("/update")
    public Student edit(@RequestBody Student student){
        Student studentBefore =   studentService.getById(student.getId());
        System.out.println("修改前：\t" + studentBefore);
        boolean flag= studentService.updateById(student);
        System.out.println("修改成功？：\t" + flag);
        Student studentAfter = studentService.getById(student.getId());
        System.out.println("修改后：\t" + studentAfter);
        return studentAfter;
    }
    @DeleteMapping("/delete")
    public  String deleteByID(@RequestParam("id") int id){
        System.out.println("查询所有(执行删除前)：\n"+studentService.list());
       boolean flag= studentService.removeById(id);
        System.out.println("删除成功？：\t" + flag);
        System.out.println("查询所有(执行删除后)：\n" + studentService.list());
        if (flag) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }
}
