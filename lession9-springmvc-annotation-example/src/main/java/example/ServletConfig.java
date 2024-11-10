package example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author admin
 * @classnam ServletConfig
 * @time 17:00
 * @date 2024/10/29
 */
@Configuration
public class ServletConfig extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        //createServletApplicationContext,用于初始化 Spring Web 应用程序的上下文，这个上下文会管理所有与 Web 相关的 Bean，比如控制器、视图解析器等。
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        return context;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//处理请求
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
