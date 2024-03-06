package com.example.demospringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/requestAttributeController")
public class RequestAttributeController {
    @RequestMapping("a")
    public String a(HttpServletRequest request){
        request.setAttribute("site",
                "<a href='http://www.itsoku.com'>路人博客，包含了所有系列文章，阅读更方便</a>");
        System.out.println("=======aaaaaaa=======");
        return "forward:/requestAttributeController/b";
    }
    @RequestMapping(value = "/b", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test2(@RequestAttribute("site") String site) {
        System.out.println(site);
        return site;
    }
}
