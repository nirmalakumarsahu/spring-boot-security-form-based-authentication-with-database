package com.sahu.springboot.security.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.info("Home page accessed");
        return "login";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        log.info("Dashboard page accessed");
        return "dashboard";
    }

}
