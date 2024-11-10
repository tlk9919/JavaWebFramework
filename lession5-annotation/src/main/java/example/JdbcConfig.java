package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class JdbcConfig {

    @Value("com.mysql.cj.jdbc")
    private String driver;

    @Value("localhost:3306//jdbc:/xxxx")
    private String url;

    @Value("root")
    private String username;

    @Value("123123")
    private String pwd;


    @Override
    public String toString() {
        return "JdbcConfig{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
