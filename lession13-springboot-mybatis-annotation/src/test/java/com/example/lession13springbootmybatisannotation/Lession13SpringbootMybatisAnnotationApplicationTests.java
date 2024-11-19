package com.example.lession13springbootmybatisannotation;

import com.example.lession13springbootmybatisannotation.dao.StudentMapper;
import com.example.lession13springbootmybatisannotation.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession13SpringbootMybatisAnnotationApplicationTests {

	@Autowired
	private StudentMapper studentMapper;

	@Test
	void save() {
		Student student =new Student();
		student.setSnum(101);
		student.setSname("zs");
		studentMapper.saveStudent(student);
	}
	@Test
	void testSelect(){
		System.out.println(studentMapper.getStudentByID(1));
	}
	@Test
	void testSelect2(){
		System.out.println(studentMapper.getStudentByName("zs"));
	}
	@Test
	void testSelect3(){
		System.out.println(studentMapper.getAllStudent());
	}
	@Test
	void testUpdate(){
		Student student =new Student();
		student.setId(5);
		student.setSnum(1101);
		student.setSname("zsss");
		System.out.println(studentMapper.updateStudentById(student));

	}
	@Test
	void deleteStudentById(){
		System.out.println(studentMapper.deleteStudentById(5));

	}


}
