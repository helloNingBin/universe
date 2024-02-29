package com.example.demospringboot.configurationProperties.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "per")
public class ProPerson {
    private String name;
    private int age;
}
