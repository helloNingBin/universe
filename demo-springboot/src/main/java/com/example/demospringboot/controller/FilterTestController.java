package com.example.demospringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class FilterTestController {

    @GetMapping("/filterTest")
    public String sayHello( String msg){
        log.info("filterTest==============");
        return "say:" + msg;
    }
}
