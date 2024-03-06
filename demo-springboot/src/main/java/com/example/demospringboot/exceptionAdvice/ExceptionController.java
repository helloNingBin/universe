package com.example.demospringboot.exceptionAdvice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @GetMapping("/e1")
    public String e1() throws Exception {
        throw new Exception("Exceptionl..........");
    }
    @GetMapping("/e2")
    public String e2() throws Exception {
        throw new ApiException("ApiException2......");
    }
}
