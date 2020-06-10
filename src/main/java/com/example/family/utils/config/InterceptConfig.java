package com.example.family.utils.config;

import com.example.family.utils.filter.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
@description
@anther  Administrator
@creater 2020-03-09 16:50
*/
public class InterceptConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercept()).excludePathPatterns("/","/").addPathPatterns("/**");
    }
}
