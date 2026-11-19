package com.springboot.boardweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // @RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "post/main"; // templates/post/main.html
    }
}
