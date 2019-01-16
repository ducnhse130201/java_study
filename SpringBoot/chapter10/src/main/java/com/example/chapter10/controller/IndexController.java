package com.example.chapter10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

    @RequestMapping("/greet")
    public String greeting() {
        return "greets";
    }

}
