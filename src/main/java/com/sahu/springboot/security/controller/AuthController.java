package com.sahu.springboot.security.controller;

import com.sahu.springboot.security.dto.UserRequestDTO;
import com.sahu.springboot.security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationPage(@ModelAttribute("user") UserRequestDTO userRequestDTO) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationProcess(@ModelAttribute("user") UserRequestDTO userRequestDTO, Map<String, Object> map) {
        log.debug("Registration process started for user: {}", userRequestDTO.userName());

        //Check if the user already exists
        if(userService.existsByUserName(userRequestDTO.userName())) {
            map.put("registrationError", "Username already exists. Please choose a different username.");
            return "registration";
        }

        if(userService.existsByEmail(userRequestDTO.email())) {
            map.put("registrationError", "Email already exists. Please choose a different email.");
            return "registration";
        }

        use


//        if (user.getEmail() != null) {
//            Optional<User> isExist = userService.findByEmail(user.getEmail());
//
//            if (isExist.isPresent()) {
//                map.put(LoginConstants.REGISTRATION_ERROR, environment.getProperty("duplicate_user_error_msg"));
//                return LVNConstants.REGISTRATION_PAGE;
//            } else {
//                Long registeredUserId = userService.registerUser(user);
//                if (registeredUserId != null) {
//                    map.put(LoginConstants.REGISTRATION_SUCCESS, environment.getProperty("registration_success_msg"));
//                } else {
//                    map.put(LoginConstants.REGISTRATION_ERROR, environment.getProperty("registration_failed_msg"));
//                }
//            }
//        }

        return "login";
    }


}
