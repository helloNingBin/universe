package com.example.demospringboot.eventListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventListenerApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EventListenerApp.class);
        springApplication.addListeners(new MyApplicationPreparedEventListener());
        springApplication.run(args);
    }
}
