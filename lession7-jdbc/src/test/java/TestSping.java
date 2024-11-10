import com.example.SpringConfig;
import com.example.Student;
import com.example.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.util.List;

/**
 * @author admin
 * @classnam TestSping
 * @time 17:44
 * @date 2024/10/21
 */
public class TestSping {
    @Test
    public void testAdd(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        //ApplicationContext是 Spring 框架的核心接口之一，负责管理 bean 的生命周期、配置和依赖注入。
        StudentController studentController=context.getBean("studentController", StudentController.class);
        Student student=new Student();
        student.setSnum(1003);
        student.setSname("wamgwu");
        studentController.addStudent(student);
    }
    @Test
    public void testDelete(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentController studentController=context.getBean("studentController", StudentController.class);
        //根据id删除数据，确保id在数据库中
        studentController.deleteStudentById(4);
    }
    @Test
    public  void testUpdate(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentController studentController=context.getBean("studentController", StudentController.class);
        //根据id从数据库查出要修改的数据
        Student student= studentController.getStudentById(2);
        //修改数据
        student.setSnum(12345);
        student.setSname("wangwu");
        //更新到数据库
        studentController.updateStudent(student);

    }
    @Test
    public  void testSelect(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentController studentController=context.getBean("studentController", StudentController.class);
        //根据id查询一条数据
        System.out.println("查询1条数据");
        Student student=studentController.getStudentById(1);
        System.out.println(student);

        System.out.println("查询全部数据");
        List<Student> students=studentController.getAllStudents();
        System.out.println(students);


    }
}
