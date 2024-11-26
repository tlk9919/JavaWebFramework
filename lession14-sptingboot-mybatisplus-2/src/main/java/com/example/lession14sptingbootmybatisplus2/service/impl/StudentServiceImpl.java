package com.example.lession14sptingbootmybatisplus2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lession14sptingbootmybatisplus2.model.Student;
import com.example.lession14sptingbootmybatisplus2.dao.StudentMapper;
import com.example.lession14sptingbootmybatisplus2.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Your Name
 * @since 2024-11-26
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {


}
