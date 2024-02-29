package com.example.demospringboot.springAnnotation.conditional.onMissBean;

import com.example.demospringboot.Person;
import com.example.demospringboot.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConditionalApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConditionalApplication.class, args);
        boolean containsStu = context.containsBean("stu");
        if(containsStu){
            Student student = context.getBean(Student.class);
            System.out.println("student:"+student);
        }
        boolean containsPer = context.containsBean("per");
        if(containsPer){
            Person person = context.getBean(Person.class);
            System.out.println("person:"+person);
        }
    }
}
