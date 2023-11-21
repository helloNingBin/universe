package com.example.demospringboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
public class MyFilterB implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilterB init.......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilterB doFilter.......");
        filterChain.doFilter(request,response);
        log.info("MyFilterB doFilter after.......");
    }

    @Override
    public void destroy() {
        log.info("MyFilterB destroy.......");
    }
}
