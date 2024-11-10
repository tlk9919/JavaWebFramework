package example;

import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * @author admin
 * @classnam WebMvcConfig
 * @time 15:58
 * @date 2024/10/29
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
// 配置视图解析器
    /*
     * 视图解析器（View Resolver）是 Spring MVC 框架中的一个重要组件，负责将控制器（Controller）返回的逻辑视图名称转换为实际的视图对象
     * */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.TEXT_HTML));
        converters.add(converter);
//        WebMvcConfigurer.super.configureMessageConverters(converters);
    }

    @Bean
    public ViewResolver InternalResourceViewResolver(){
        InternalResourceViewResolver resolver =new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
