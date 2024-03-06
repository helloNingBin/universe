package com.configure;

import com.properties.SpeakerProperties;
import com.service.SpeakerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import starter.Speaker;

@Configuration
@EnableConfigurationProperties(SpeakerProperties.class)
public class SperkerConfig {
    @Autowired
    private SpeakerProperties s;
    @Bean
    public SpeakerSerivce speaker(SpeakerProperties speakerProperties){
        System.out.println("s:" + s);
        System.out.println("speakerProperties:"+speakerProperties);
        SpeakerSerivce speaker = new SpeakerSerivce();
        speaker.setName(speakerProperties.getName());
        speaker.setName2(speakerProperties.getName2());
        return speaker;
    }
}
