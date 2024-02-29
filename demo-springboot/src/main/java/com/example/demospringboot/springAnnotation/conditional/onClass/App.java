package com.example.demospringboot.springAnnotation.conditional.onClass;

import com.example.demospringboot.Person;
import com.example.demospringboot.Student;
import com.example.demospringboot.springAnnotation.conditional.onMissBean.ConditionalApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
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
