package com.example.lession17springbootinterceptator.Config;

import com.example.lession17springbootinterceptator.authInterceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author admin
 * @classnam WebConfig
 * @time 18:48
 * @date 2024/12/10
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor authInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**").excludePathPatterns("/user/login","/user/doLogin");
    }
}
