package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @classnam StudentServiceImpl
 * @time 17:30
 * @date 2024/10/29
 */
@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int res=studentDao.save(student);
        System.out.println("成功添加数据" + res + "条");
        return res;
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public int updateStudent(Student student) {
        int res=studentDao.update(student);
        System.out.println("成功更新数据" + res + "条");
        return res;
    }

    @Override
    public int deleteStudentById(int id) {
        int res=studentDao.deleteById(id);
        System.out.println("成功删除数据" + res + "条");
        return res;
    }

}
