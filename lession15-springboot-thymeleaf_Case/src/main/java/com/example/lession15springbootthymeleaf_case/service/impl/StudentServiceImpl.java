package com.example.lession15springbootthymeleaf_case.service.impl;

import com.example.lession15springbootthymeleaf_case.model.Student;
import com.example.lession15springbootthymeleaf_case.dao.StudentMapper;
import com.example.lession15springbootthymeleaf_case.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin_tlk
 * @since 2024-12-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
