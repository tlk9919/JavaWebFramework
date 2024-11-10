package aop.tx;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * @classnam AccountService
 * @time 16:33
 * @date 2024/10/19
 */
@Service
public class AccountService {
    public Boolean transfer(int accountA,int accountB){
        System.out.println("AccountService:执行转账操作");
        return accountA >= accountB;
    }
}
