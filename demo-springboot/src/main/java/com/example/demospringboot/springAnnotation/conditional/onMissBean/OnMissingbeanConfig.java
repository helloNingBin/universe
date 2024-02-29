package com.example.demospringboot.springAnnotation.conditional.onMissBean;

import com.example.demospringboot.Person;
import com.example.demospringboot.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnMissingbeanConfig {
    @ConditionalOnMissingBean(name = "per")
    @Bean("stu")
    public Student student(){
        return new Student("ss");
    }
    @ConditionalOnMissingBean(name = "stu")
    @Bean("per")
    public Person person(){
        return new Person("kk");
    }
}
