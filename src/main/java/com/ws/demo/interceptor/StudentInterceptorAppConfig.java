package com.ws.demo.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class StudentInterceptorAppConfig implements WebMvcConfigurer {
    @Autowired
    StudentInterceptor studentInterceptor;

    public void AddInterceptor(final InterceptorRegistry registry){
        registry.addInterceptor(studentInterceptor); 
    }
}
