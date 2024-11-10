package auto;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByid() {
        System.out.println("UserService: getUserByid");
        return userDao.getUserByid();
    }
}
