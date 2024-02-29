package com.example.demospringboot.springAnnotation.conditional.onClass;

import com.example.demospringboot.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnclassConfig {
    @ConditionalOnClass(name = "com.example.demospringboot.Student3")
    @Bean("stu")
    public Student student(){
        return new Student("ss");
    }
}
