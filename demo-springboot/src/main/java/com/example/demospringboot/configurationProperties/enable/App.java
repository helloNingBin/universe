package com.example.demospringboot.configurationProperties.enable;

import com.example.demospringboot.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
    @Autowired
    private ProPerson person;
    @Autowired
    private Person person2;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(person);
        System.out.println(person2);
    }
}
