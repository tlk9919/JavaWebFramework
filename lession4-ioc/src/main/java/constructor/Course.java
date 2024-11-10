package constructor;

/**
 * @author admin
 * @classnam Course
 * @time 15:13
 * @date 2024/10/12
 */
public class Course {
    private Integer num;
    private  String Cname;

    public Course(Integer num, String cname) {
        this.num = num;
        Cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "num=" + num +
                ", Cname='" + Cname + '\'' +
                '}';
    }
}
