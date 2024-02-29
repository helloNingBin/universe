package com.example.demospringboot.configurationProperties.ymlAndProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Component
@ConfigurationProperties(prefix = "prop")
public class PropertiesBean {
    private String str;
    private Boolean boo;
    private Date date;
    private Integer i;
    private Pet pet;
    private String[] array;
    private List<String> list;
    private Map<String, Object> map1;
    private Map<String, Object> map2;
    private Map<String, Object> map3;
    private Set<Double> set;
    private Map<String, List<Pet>> mapAndList;
}
