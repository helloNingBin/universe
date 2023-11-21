package com.example.demospringboot.service.impl;

import com.example.demospringboot.domain.LoginUser;
import com.example.demospringboot.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class UserMapper {
    public static Map<String, User> userMap = new HashMap<>();
    //模拟Redis
    public static Map<String, LoginUser> loginUserMap = new HashMap<>();
    static {
        String[] users = {"admin","test","ningibn"};
        for(String u : users){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            User user = new User();
            user.setUserName(u);
            user.setPassword(encoder.encode(u));
            userMap.put(u, user);
        }
    }
}
