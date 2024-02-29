package com.example.demospringboot.configurationProperties.enable;

import com.example.demospringboot.Person;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ProPerson.class, Person.class})
public class EnableConfigurationPropertiesConfig {
}
