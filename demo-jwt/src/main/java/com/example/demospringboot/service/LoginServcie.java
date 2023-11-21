package com.example.demospringboot.service;


import com.example.demospringboot.domain.ResponseResult;
import com.example.demospringboot.domain.User;

public interface LoginServcie {
    ResponseResult login(User user);

    ResponseResult logout();

}
