package example;

/**
 * @author admin
 * @classnam Student
 * @time 17:18
 * @date 2024/10/29
 */
public class Student {
    private  Integer id;
    private  Integer snum;
    private  String sname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", snum=" + snum +
                ", sname='" + sname + '\'' +
                '}';
    }
}
