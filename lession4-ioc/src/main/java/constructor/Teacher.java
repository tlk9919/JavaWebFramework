package constructor;

/**
 * @author admin
 * @classnam Teacher
 * @time 14:49
 * @date 2024/10/12
 */
public class Teacher {
    private Integer num;
    private String tname;

    public Teacher(Integer num, String tname) {
        this.num = num;
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "num=" + num +
                ", tname='" + tname + '\'' +
                '}';
    }
}
