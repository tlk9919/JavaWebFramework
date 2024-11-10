package auto;

public class User {

    private Integer num;

    private String name;

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
