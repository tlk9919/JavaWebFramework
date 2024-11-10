package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("userDaoImpl1")
    private UserDao userDao;



    public void getUser(){
        System.out.println("UserService: 查询用户");
        userDao.getUser();
    }
}
