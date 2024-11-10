package tx;

/**
 * @author admin
 * @classnam Account
 * @time 21:36
 * @date 2024/10/21
 */
public class Account {
    private Integer id;

    private  Integer accountId;

    private  String name;

    private  Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
