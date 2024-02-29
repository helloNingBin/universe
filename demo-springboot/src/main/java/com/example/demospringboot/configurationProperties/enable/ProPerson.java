package com.example.demospringboot.configurationProperties.enable;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "per")
public class ProPerson {
    private String name;
    private int age;
    private String remark;
}
