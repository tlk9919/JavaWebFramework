package example;
import java.util.List;

public interface StudentDao {
    int save (Student student); // 保存一个学生，返回操作的结果（通常是受影响的行数或生成的 ID）

    Student findById(int id);

    List<Student> findAll();

    int update(Student student);

    int deleteById(int id);
}
