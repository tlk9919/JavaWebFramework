package aop.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author admin
 * @classnam UserController
 * @time 17:27
 * @date 2024/10/19
 */
@Controller
public class UserControllerlog {
    @Autowired
    private UserService userService;

    public void add() {
        userService.addUser();
    }

    public void delete() {
        userService.deleteUser();
    }

    public void update() {
        userService.updateUser();
    }

    public void query() {
        userService.queryUser();
    }


}
