package com.example.demospringboot.configuration;

import com.example.demospringboot.filter.MyFilterA;
import com.example.demospringboot.filter.MyFilterB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

/**
 * MyFilterA  -> MyFilterB -> Interceptor
 */
@Configuration
public class FilterConfig {
    @Autowired
    private MyFilterA myFilterA;
    @Autowired
    private MyFilterB myFilterB;
    @Bean
    public FilterRegistrationBean createMyFilterA(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("myFilterA");
        registrationBean.setFilter(myFilterA);
        registrationBean.addUrlPatterns("/filterTest");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean createMyFilterBS(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("myFilterB");
        registrationBean.setFilter(myFilterB);
        registrationBean.addUrlPatterns("/filterTest");
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
