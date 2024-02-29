package com.example.demospringboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.Date;
@ConfigurationProperties(prefix = "per")
public class Person implements Serializable {
    private String name;
    //私有属性
    private int age;
    //公有静态属性
    public static String s = "xxx";
    //无参构造方法
    public Person(){
    }
    //有参构造方法
    public Person(String name){
        this.name = name;
    }
    //公有方法
    public void pub(){

    }
    //私有方法
    private void pri(){

    }
    //静态方法
    private static void sta(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
