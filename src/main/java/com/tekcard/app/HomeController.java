package com.tekcard.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    ApplicationContext context;

    @Value("${spring.thymeleaf.prefix}")
    private String prefix;

    @GetMapping("/")
    public ModelAndView app() {
        return new ModelAndView("index.html");
    }

    @GetMapping("/test")
    public String test() {
        return "index";
    }
}
