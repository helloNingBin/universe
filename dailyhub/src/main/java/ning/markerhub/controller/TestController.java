package ning.markerhub.controller;

import ning.markerhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @GetMapping("/test")
    public Object test() {
        int i = 1/0;
        return userRepository.findAll();
    }
    @GetMapping("/ftl")
    public String ftl(HttpServletRequest req) {
        int i = 1/0;
        req.setAttribute("user", userRepository.getOne(1L));
        return "test";
    }
}