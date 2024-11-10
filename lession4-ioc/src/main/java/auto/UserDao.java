package auto;

public class UserDao {

    public User getUserByid() {
        User user = new User();
        user.setNum(1001);
        user.setName("zhangsan");
        System.out.println("UserDao: getUserByid");
        return user;
    }
}
