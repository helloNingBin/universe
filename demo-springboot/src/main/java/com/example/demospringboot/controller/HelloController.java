package com.example.demospringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class HelloController {
    @Autowired
    HttpSession httpSession;
    @GetMapping("/sayHello")
    public String sayHello(HttpSession session,String msg){
        log.info("成员变量session:{},参数session:{}，是否相等{}",httpSession,session,(httpSession==session));
        return "say:" + msg;
    }
    @GetMapping("/setSession")
    public String setSession(){
        httpSession.setAttribute("str", "xxxxxxxxx");
        return "ok";
    }
    @GetMapping("/getSession")
    public String getSession(HttpServletRequest request){
        return request.getSession().getAttribute("str")+"";
    }
}
