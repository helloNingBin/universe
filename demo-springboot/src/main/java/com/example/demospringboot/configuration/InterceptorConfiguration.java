package com.example.demospringboot.configuration;

import com.example.demospringboot.interceptor.InterceperA;
import com.example.demospringboot.interceptor.InterceperB;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    /**
     * 该拦截器主要是为了权限验证
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceperA()).addPathPatterns("/**");
        registry.addInterceptor(interceperA()).addPathPatterns("/filterTest");
        registry.addInterceptor(interceperB()).addPathPatterns("/filterTest");
    }

    @Bean
    @ConfigurationProperties(prefix = "secure.ignored")
    public InterceperA interceperA(){
        return new InterceperA();
    }
    @Bean
    //@ConfigurationProperties(prefix = "secure.ignored")
    public InterceperB interceperB(){
        return new InterceperB();
    }
}