package com.sahu.springboot.security.constant;

import lombok.experimental.UtilityClass;

public interface AuthConstants {
    String REGISTRATION_PAGE = "registration";
    String LOGIN_PAGE = "login";
    String DASHBOARD_PAGE = "dashboard";

    String REGISTRATION_ERROR = "registrationError";
    String REGISTRATION_SUCCESS = "registrationSuccess";

    String LOGIN_URL = "/login";
    String REGISTRATION_URL = "/registration";
    String LOGOUT_URL = "/logout";
    String DASHBOARD_URL = "/dashboard";

    String ROLE_USER = "USER";
    String ROLE_ADMIN = "ADMIN";
    String ROLE_PREFIX = "ROLE_";
}
