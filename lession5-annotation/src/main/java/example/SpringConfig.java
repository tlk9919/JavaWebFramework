package example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("example")
public class SpringConfig {

    @Bean
    public JdbcConfig createJdbcConfig(){
        return new JdbcConfig();
    }
}
