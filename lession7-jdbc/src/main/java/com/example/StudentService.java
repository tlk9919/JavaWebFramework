package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @classnam StudentService
 * @time 17:18
 * @date 2024/10/21
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    public void addStudent(Student student){
        int res=studentDao.save(student);
        System.out.println("成功添加数据"+res+"条");
    }
    public Student getStudentById( int id){
        return  studentDao.findById(id);
    }
    public List<Student> getAllStudents(){
        return  studentDao.findAll();
    }
    public void updateStudent( Student student){
        int res=studentDao.update(student);
        System.out.println("成功更新数据"+res+"条");
    }
    public void deleteStudentById(int id){
        int res=studentDao.deleteById(id);
        System.out.println("成功删除数据"+res+"条");
    }
}
