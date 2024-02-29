package com.example.demospringboot.configurationProperties.ymlAndProperties;

import com.example.demospringboot.Person;
import com.example.demospringboot.configurationProperties.enable.ProPerson;
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
    private YmlBean ymlBean;
    @Autowired
    private PropertiesBean propertiesBean;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(ymlBean);
        System.out.println(propertiesBean);
    }
}
