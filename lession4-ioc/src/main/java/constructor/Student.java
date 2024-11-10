package constructor;

import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @classnam Student
 * @time 15:16
 * @date 2024/10/12
 */
public class Student {
    private Integer num;
    private String sanme;
    private String age;
    private String sex;
    private Teacher classTeacher;
    private String[] hobby;
    private List<Course> courses;

    public Student(Integer num, String sanme, String age, String sex, Teacher classTeacher, String[] hobby, List<Course> courses) {
        this.num = num;
        this.sanme = sanme;
        this.age = age;
        this.sex = sex;
        this.classTeacher = classTeacher;
        this.hobby = hobby;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", sanme='" + sanme + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", classTeacher=" + classTeacher +
                ", hobby=" + Arrays.toString(hobby) +
                ", courses=" + courses +
                '}';
    }
}
