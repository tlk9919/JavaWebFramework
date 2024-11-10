package aop.log;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * @classnam UserServiceImpl
 * @time 17:25
 * @date 2024/10/19
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("添加用户...");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户...");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户...");
    }

    @Override
    public void queryUser() {
        System.out.println("查询用户...");

    }
}
