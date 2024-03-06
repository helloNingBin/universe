package com.example.demospringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
    @RequestMapping("/showPic/{name}")
    public String showPic(@PathVariable("name") String name){
        System.out.println("========@@@@1111@@");
        return "" + name;
    }
}
