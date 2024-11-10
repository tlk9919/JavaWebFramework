package example;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl1 implements UserDao{

    @Override
    public void getUser(){
        System.out.println("UserDaoImpl1: 查询用户");
    }
}
