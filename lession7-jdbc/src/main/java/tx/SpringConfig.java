package tx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author admin
 * @classnam SpringConfig
 * @time 21:39
 * @date 2024/10/21
 */
@Configuration
@ComponentScan("tx")
public class SpringConfig {
    //配置数据源
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javaweb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    //// 配置JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        //等价dbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //return jdbcTemplate;
        return new JdbcTemplate(dataSource);
    }
    //配置事务管理器
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager (DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
