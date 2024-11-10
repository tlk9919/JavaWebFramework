package aop.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author admin
 * @classnam UserController
 * @time 16:38
 * @date 2024/10/19
 */
@Controller
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderService orderService;

    public String shopping() {
        System.out.println("UserController:开始购物");
        if (orderService.create() && accountService.transfer(12, 5)) {
            return "UserController:购买成功";
        } else {
            return "UserController:购买失败";
        }
    }
}