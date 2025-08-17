package com.sahu.springboot.security.controller;

import com.sahu.springboot.security.constant.AuthConstants;
import com.sahu.springboot.security.dto.UserRequestDTO;
import com.sahu.springboot.security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return AuthConstants.LOGIN_PAGE;
    }

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return AuthConstants.REGISTRATION_PAGE;
    }

    @PostMapping("/registration")
    public String registrationProcess(@ModelAttribute("user") UserRequestDTO userRequestDTO, Map<String, Object> map) {
        log.debug("Registration process started for user: {}", userRequestDTO.username());

        //Check if the user already exists
        if(userService.existsByUsername(userRequestDTO.username())) {
            map.put(AuthConstants.REGISTRATION_ERROR, "Username already exists. Please choose a different username.");
            return AuthConstants.REGISTRATION_PAGE;
        }

        if(userService.existsByEmail(userRequestDTO.email())) {
            map.put(AuthConstants.REGISTRATION_ERROR, "Email already exists. Please choose a different email.");
            return "registration";
        }

        //Add the user
        if(Objects.nonNull(userService.addUser(userRequestDTO))) {
            map.put(AuthConstants.REGISTRATION_SUCCESS, "Registration successful! You can now log in.");
            return AuthConstants.LOGIN_PAGE;

        } else {
            map.put(AuthConstants.REGISTRATION_ERROR, "Registration failed. Please try again.");
            return AuthConstants.REGISTRATION_PAGE;
        }
    }


}
