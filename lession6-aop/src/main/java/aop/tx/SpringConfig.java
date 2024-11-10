package aop.tx;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author admin
 * @classnam SpringConfig
 * @time 16:59
 * @date 2024/10/19
 */
@Configuration
@ComponentScan("aop.tx")
@EnableAspectJAutoProxy //启用AspectJ的自动代理支持。它使得Spring能够识别用@Aspect注解标记的切面，并将其应用于被扫描的类中。
public class SpringConfig {
}
