package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @classnam AccountDaoImpl
 * @time 22:00
 * @date 2024/10/21
 */
@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account queryAccountByID(Integer accountId) {
        String sql="select * from t_account where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Account.class),accountId);
    }

    @Override
    public int updateAccount(Account account) {
        String sql="update t_account set balance=?   where accountId=?";
        return jdbcTemplate.update(sql,account.getBalance(),account.getAccountId());
        //update 方法返回一个整数，表示数据库中成功更新的记录数。
    }
}
