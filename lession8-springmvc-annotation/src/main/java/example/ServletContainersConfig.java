package example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author admin
 * @classnam ServletContainersConfig
 * @time 16:59
 * @date 2024/10/22
 */
@Configuration
public class ServletContainersConfig extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        //这是一个 WebApplicationContext 的实现，支持基于注解的配置。
        //功能：允许开发者通过 Java 注解（如 @Configuration）来定义 Spring 的 bean，而不是使用 XML 配置文件。
        ctx.register(SpringConfig.class);
        // SpringConfig 类注册到 AnnotationConfigWebApplicationContext 中
        return ctx;
    }

    @Override
    protected String[] getServletMappings() {
        //这个返回值通常在 getServletMappings() 方法中使用，指示哪些请求路径将由 DispatcherServlet 处理。
        return new String[]{"/"};
        //含义：这是创建一个新的字符串数组，并初始化其内容为 "/"。
        //功能：在这个数组中只包含一个元素，即根路径 /。
        //是配置 DispatcherServlet 来处理所有请求路径
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        //WebApplicationContext是 ApplicationContext 的一个特化，管理应用中所有的 bean 和其依赖关系，负责创建、初始化和销毁这些 bean。
        return null;//通过返回 null，表示不需要一个独立的根应用上下文。这意味着应用只使用 DispatcherServlet 的上下文来管理所有的 bean。
    }
}
