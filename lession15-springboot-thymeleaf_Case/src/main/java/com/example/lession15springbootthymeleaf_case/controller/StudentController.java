package com.example.lession15springbootthymeleaf_case.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.lession15springbootthymeleaf_case.model.Student;
import com.example.lession15springbootthymeleaf_case.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin_tlk
 * @since 2024-12-02
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    //查询所有学生
    @GetMapping("/all")
    public String searchAll(Model model){
        List<Student> studentList=studentService.list();
        System.out.println(studentList);
        model.addAttribute("students", studentList);
        return "student";
    }
    //根据id查询
    @GetMapping("/searchById")
    public Student searchById(@RequestParam("id") int id){
        System.out.println(id);
        Student student=studentService.getById(id);
        System.out.println(student);
        return student;
    }
    //根据名字查询
    @GetMapping("/searchByName")
    public List<Student> searchByName(@RequestParam("name") String name){
        QueryWrapper<Student > queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sname",name);
        List<Student> studentList=studentService.list(queryWrapper);
        return studentList;
    }
    //模糊查询
    @GetMapping("/searchByNameFuzzy")
    public List<Student> searchByNameFuzzy(@RequestParam("name") String name){
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("sname",name);
        List<Student> studentList=studentService.list(queryWrapper);
        return studentList;
    }
    //学生注册
    @PostMapping("/register")
    public String register(@RequestBody Student student){
        boolean flag= studentService.save(student);
        if(flag){
            return "注册成功";
        }
        else{
            return "registered failed";
        }
    }
    //学生更新
    @PutMapping("/update")
    public Student update(@RequestBody Student student){
        Student studentBefore=studentService.getById(student.getId());
        System.out.println("修改前：\t" + studentBefore);
        boolean flag=studentService.updateById(student);
        System.out.println("修改成功？：\t" + flag);
        Student studentAfter = studentService.getById(student.getId());
        System.out.println("修改后：\t" + studentAfter);
        return studentAfter;
    }

    @DeleteMapping("/delete")
    public String deleteByID(@RequestParam("id") Integer id) {
        System.out.println("查询所有(执行删除前)：\n" + studentService.list());
        // 根据id删除
        boolean flag = studentService.removeById(id);
        System.out.println("删除成功？：\t" + flag);
        System.out.println("查询所有(执行删除后)：\n" + studentService.list());
        if (flag) {
            return "redirect:/student";  //重定向到/student
        } else {
            return "error";
        }

}
