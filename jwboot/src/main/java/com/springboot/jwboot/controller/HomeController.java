package com.springboot.jwboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController     // 문자열 반환
@Controller
public class HomeController {

    @GetMapping("/")
    public  String home()
    {
        // return "<h1>SpringBoot framework Study</h2>";
        return "index"; // templates/index.html
    }

    @GetMapping("/time")
    public String time()
    {
        return "pages/time";    // templates/pages/time.html
    }
}
