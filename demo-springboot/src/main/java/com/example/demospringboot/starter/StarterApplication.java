package com.example.demospringboot.starter;

import com.service.SpeakerSerivce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import starter.Speaker;

@SpringBootApplication
public class StarterApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(StarterApplication.class, args);
        Speaker speaker = run.getBean(Speaker.class);
        System.out.println("speaker:" + speaker.say("speaker"));
        SpeakerSerivce bean = run.getBean(SpeakerSerivce.class);
        System.out.println("SpeakerSerivce:" + bean.say("speakerService"));
    }
}
