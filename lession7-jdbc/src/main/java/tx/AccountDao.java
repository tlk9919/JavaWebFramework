package tx;

/**
 * @author admin
 * @classnam AccountDao
 * @time 21:57
 * @date 2024/10/21
 */
public interface AccountDao {
    Account queryAccountByID(Integer accountId);
    int updateAccount(Account account);
}
