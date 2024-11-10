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
 * @time 17:07
 * @date 2024/10/29
 */
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

    /*
     * 设置Spring MVC应用中支持的消息转换器
     * */
    //converters 是一个列表，包含了所有可用的 HttpMessageConverter 实例
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();//josn
        converter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_XML));
        //支持的类型 表示 JSON 格式的数据、HTML 格式的数据、 XML 格式的数据
        converters.add(converter);
    }

    //配置视图解析器
    @Bean
    public ViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();//InternalResourceViewResolver 是 Spring 提供的一个视图解析器
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        resolver.setContentType("text/html;charset=UTF-8");
        return resolver;
    }
}
