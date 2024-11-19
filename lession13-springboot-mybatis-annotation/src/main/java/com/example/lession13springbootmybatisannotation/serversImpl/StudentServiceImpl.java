package com.example.lession13springbootmybatisannotation.serversImpl;

import com.example.lession13springbootmybatisannotation.dao.StudentMapper;
import com.example.lession13springbootmybatisannotation.model.Student;
import com.example.lession13springbootmybatisannotation.servers.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @classnam StudentServiceImpl
 * @time 17:41
 * @date 2024/11/19
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public int addStudent(Student student) {
        return studentMapper.saveStudent(student);
    }

    @Override
    public Student getStudentByID(int id) {
        return studentMapper.getStudentByID(id);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentMapper.getStudentByName(name);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public int updateStudentById(Student student) {
        return studentMapper.updateStudentById(student);
    }

    @Override
    public int deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id);
    }
}
