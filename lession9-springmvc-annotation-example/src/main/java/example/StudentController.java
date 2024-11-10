package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @classnam StudentController
 * @time 17:43
 * @date 2024/10/29
 */
@Controller
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/welcome")
    @ResponseBody
    public String showWelcome() {
        return "学生信息管理平台";
    }

    @PostMapping("/add")//用于向服务器发送数据以创建新资源。常用于添加操作，例如提交表单数据。
    @ResponseBody
    public String addStudent(@RequestBody Student student) {
        // student 对象会自动映射请求体中的 JSON 数据
        //@RequestBody用于将 HTTP 请求的主体（body）内容映射到一个 Java 对象。
        System.out.println(student);
        if (1 == studentService.addStudent(student)) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @GetMapping("/get")//通常用于查询操作，例如获取某个资源或多个资源。
    @ResponseBody
    public String getStudentById(@RequestParam("id") int id) {
        //id 是查询参数
        System.out.println("get id --->" + id);
        return studentService.getStudentById(id).toString();
    }

    @GetMapping("/get2/{sid}")
    @ResponseBody
    public Student getStudentById2(@PathVariable(name = "sid") int id) {
        //@PathVariable是路径变量
        System.out.println("get2 id --->" + id);
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public String getAllStudents() {

        return studentService.getAllStudents().toString();
    }

    @PutMapping("/edit")//用于向服务器发送数据以更新现有资源。通常用于编辑或更新操作。
    @ResponseBody
    public String updateStudent(Student student) {
        if (1 == studentService.updateStudent(student)) {
            return "编辑成功";
        } else {
            return "编辑失败";
        }
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteStudentById(@RequestParam("id") int id) {
        if (1 == studentService.deleteStudentById(id)) {
            return "删除成功";
        } else {
            return "删除失败";
        }

    }

}