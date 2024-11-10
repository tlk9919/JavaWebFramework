package aop.log;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @classnam SpringConfig
 * @time 17:37
 * @date 2024/10/19
 */
@Configuration
@Component("aop.log")
@EnableAspectJAutoProxy
public class SpringConfiglog {
}
