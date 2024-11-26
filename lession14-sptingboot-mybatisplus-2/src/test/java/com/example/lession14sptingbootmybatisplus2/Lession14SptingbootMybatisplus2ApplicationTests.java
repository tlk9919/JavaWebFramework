package com.example.lession14sptingbootmybatisplus2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lession14sptingbootmybatisplus2.dao.StudentMapper;
import com.example.lession14sptingbootmybatisplus2.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Lession14SptingbootMybatisplus2ApplicationTests {

    @Autowired
    private StudentMapper studentMapper;
    @Test
    void contextLoads() {
        Student student=new Student();
        student.setSnum(123);
        student.setSname("Smith");
        int flag= studentMapper.insert(student);
       System.out.println(flag);
    }
    @Test
    void testGetByID(){
        Student student=studentMapper.selectById(123);
        System.out.println("查询成功："+student);
    }
    @Test
    void testGetByName(){
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sname","Bob");
        System.out.println(studentMapper.selectList(queryWrapper));
    }
}
