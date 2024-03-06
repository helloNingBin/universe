package com.example.demospringboot.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("=======HelloController");
        model.addAttribute("message", "Hello, Thymeleaf!!!");
        return "hello"; // 返回Thymeleaf模板文件的名称，不需要指定文件后缀
    }
}
