package example;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl2 implements UserDao{

    @Override
    public void getUser(){
        System.out.println("UserDaoImpl2: 查询用户");
    }
}
