package com.example.lession16springbootexception.service.impl;

import com.example.lession16springbootexception.model.Student;
import com.example.lession16springbootexception.dao.StudentMapper;
import com.example.lession16springbootexception.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Your Name
 * @since 2024-12-03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
