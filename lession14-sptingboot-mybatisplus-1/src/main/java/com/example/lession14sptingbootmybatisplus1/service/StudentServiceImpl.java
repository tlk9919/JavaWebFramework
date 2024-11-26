package com.example.lession14sptingbootmybatisplus1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lession14sptingbootmybatisplus1.dao.StudentMapper;
import com.example.lession14sptingbootmybatisplus1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @classnam StudentServiceImpl
 * @time 17:17
 * @date 2024/11/26
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student getStudentByID(int id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sname", name);
        return studentMapper.selectList(queryWrapper);
    }

    @Override
    public List<Student> getStudentByNameFuzzy(String name) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("sname", name);
        return studentMapper.selectList(queryWrapper);
    }

    @Override
    public List<Student> getAllStudent() {
        return this.list();
    }

    @Override
    public int updateStudentById(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public int deleteStudentById(int id) {
        return studentMapper.deleteById(id);
    }
}
