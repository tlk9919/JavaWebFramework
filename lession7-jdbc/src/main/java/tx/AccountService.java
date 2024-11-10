package tx;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * @classnam AccountService
 * @time 17:22
 * @date 2024/10/22
 */
public interface AccountService {
public boolean transfer(Integer fromAccountId,Integer toAccountId,double money)throws Exception;
}
