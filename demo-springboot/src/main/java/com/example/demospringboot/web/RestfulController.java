package com.example.demospringboot.web;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RestfulController {
    @GetMapping("/user")
//@RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        System.out.println("GET-张三");
        return "GET-张三";
    }

    @PostMapping("/user")
//@RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(HttpServletRequest request){
        System.out.println("POST-张三" + request.getParameter("remark"));
        return "POST-张三" + request.getAttribute("remark");
    }

    @PutMapping("/user")
//@RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        System.out.println("PUT-张三");
        return "PUT-张三";
    }

    @DeleteMapping("/user")
//@RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        System.out.println("DELETE-张三");
        return "DELETE-张三";
    }

}
