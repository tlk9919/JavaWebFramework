package com.example.lession14sptingbootmybatisplus1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lession14sptingbootmybatisplus1.dao.StudentMapper;
import com.example.lession14sptingbootmybatisplus1.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession14SptingbootMybatisplus1ApplicationTests {

	@Autowired
	private StudentMapper studentMapper;

	@Test
	void contextLoads() {
		Student student=new Student();
		student.setSnum(123);
		student.setSname("Bob");
		 int flag=studentMapper.insert(student);
		 System.out.println("新增结果：\t"+student);
	}

	@Test
	void testGetByID(){
		Student student=studentMapper.selectById(1);
		System.out.println("查询结果：\t"+student);
	}
	@Test
	void testGetByName(){
		QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("sname","zs");
		System.out.println(studentMapper.selectList(queryWrapper));
	}

}
