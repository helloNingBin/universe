package com.example.demospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class JWTSpringbootApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(JWTSpringbootApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new JWTHandlerInterceptor()).addPathPatterns("/api*");
    }
}
