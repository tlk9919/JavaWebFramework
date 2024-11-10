package example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author admin
 * @classnam SpringConfig
 * @time 16:42
 * @date 2024/10/22
 */
@Configuration
@ComponentScan("example")
@EnableWebMvc
//启用Spring MVC的功能，当在一个配置类上使用这个注解时，它会告诉Spring框架接管所有的Spring MVC配置。这意味着Spring会寻找控制器、视图解析器、拦截器等与Web MVC相关的bean，并且会自动配置它们以支持Web MVC功能。

public class SpringConfig {
// 配置视图解析器
    /*
     * 视图解析器（ViewResolver）是 Spring MVC 框架中的一个重要组件，负责将控制器（Controller）返回的逻辑视图名称转换为实际的视图对象
     * */
    public ViewResolver InternalResourceViewResolver(){
        InternalResourceViewResolver resolver =new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
