package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author admin
 * @classnam AccountController
 * @time 17:47
 * @date 2024/10/22
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    public String transfer() throws Exception{
        boolean res = accountService.transfer(2024001,2024002,10);
        if (res){
            return "转账成功！";
        }else {
            return "转账失败！";
        }
    }
}
