package com.study.transactional.config;

import com.study.transactional.interceptor.RequestLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//Spring won’t use it unless we register it.
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    RequestLoggingInterceptor loggingInterceptor;


    public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loggingInterceptor).addPathPatterns("/api/**")     // apply to APIs
            .excludePathPatterns("/api/auth/**"); // skip login
    }
}
