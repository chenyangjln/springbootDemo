package com.example.testsix.conpent;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Alex
 * @create 2019-12-03 21:03
 */
@Configuration
public class SessionConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/loginView")
                //放行静态资源
                .excludePathPatterns("/img/**", "/css/**", "/fonts/**", "/js/**");
    }
}
