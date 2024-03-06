package com.example.demospringboot.configurationProperties.enable;

import com.example.demospringboot.Person;
import com.example.demospringboot.proxy.ProxyBean;
import com.example.demospringboot.proxy.ProxyInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ProPerson.class, Person.class})
public class EnableConfigurationPropertiesConfig {

    @Bean
    public ProxyInterface proxyInterface(ProPerson proPerson){
        System.out.println("proPerson:::" + proPerson);
        return new ProxyBean(proPerson.getName());
    }
}
