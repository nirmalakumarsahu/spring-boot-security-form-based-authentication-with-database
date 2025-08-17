package com.sahu.springboot.security.controller;

import com.sahu.springboot.security.constant.AuthConstants;
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
        return AuthConstants.LOGIN_PAGE;
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        log.info("Dashboard page accessed");
        return AuthConstants.DASHBOARD_PAGE;
    }

    @GetMapping("/admin-dashboard")
    public String showAdminDashboard() {
        log.info("Admin Dashboard page accessed");
        return AuthConstants.ADMIN_DASHBOARD_PAGE;
    }

    @GetMapping("/user-dashboard")
    public String showUserDashboard() {
        log.info("User Dashboard page accessed");
        return AuthConstants.USER_DASHBOARD_PAGE;
    }

}
