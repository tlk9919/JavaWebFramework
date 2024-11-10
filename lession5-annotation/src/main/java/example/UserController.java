package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    public void getUser() {
        System.out.println("UserController：查询用户");
        userService.getUser();
    }

}
