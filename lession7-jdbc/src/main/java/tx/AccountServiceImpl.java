package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 * @classnam AccountServiceImpl
 * @time 17:26
 * @date 2024/10/22
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
private AccountDao accountDao;

    @Override
    public boolean transfer(Integer fromAccountId, Integer toAccountId, double money) throws Exception {
        //余额查询
        Account fromAccount=accountDao.queryAccountByID(fromAccountId);
        if(fromAccount.getBalance()<money){
            System.out.println("余额不足");
            throw new Exception("余额不足");
        }
        //开始转账
        Account toAccount=accountDao.queryAccountByID(toAccountId);
        System.out.println("开始转账");
        System.out.println("From Account:\t" + fromAccount);
        System.out.println("To Account:\t" + toAccount);
        System.out.println("金额:\t" + money);

        fromAccount.setBalance(fromAccount.getBalance()-money);
        toAccount.setBalance(toAccount.getBalance()+money);

        int tag1=accountDao.updateAccount(fromAccount);
        int tag2=accountDao.updateAccount(toAccount);

        // 转账结果
        if (tag1 != tag2) {
            System.out.println("程序异常，转账失败！");
            throw new Exception("程序异常，转账失败！");
        } else {
            System.out.println("转账完成");
            Account fAccount = accountDao.queryAccountByID(fromAccountId);
            Account tAccount = accountDao.queryAccountByID(toAccountId);
            System.out.println("From Account:\t" + fAccount);
            System.out.println("To Account:\t" + tAccount);
        }
        return  tag1 == tag2;
    }
}
