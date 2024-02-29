package com.example.demospringboot.springAnnotation;

import com.example.demospringboot.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelAttributeUse {
    @GetMapping("/hello")
    public String hello(@ModelAttribute("personModel") Person p){
        return "ok"+p;
    }
    @ModelAttribute("personModel")
    public Person person(Person person){
        System.out.println("在执行controller方法前，会执行ModelAttribute注解的方法" +
                ",并且也能接收request的参数值" + person);
        return new Person("ningbin");
    }
}
