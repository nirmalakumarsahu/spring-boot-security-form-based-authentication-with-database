package com.sahu.springboot.security.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthConstants {
    public final String REGISTRATION_PAGE = "registration";
    public final String LOGIN_PAGE = "login";
    public final String DASHBOARD_PAGE = "dashboard";
    public final String USER_DASHBOARD_PAGE = "user-dashboard";
    public final String ADMIN_DASHBOARD_PAGE = "admin-dashboard";

    public final String REGISTRATION_ERROR = "registrationError";
    public final String REGISTRATION_SUCCESS = "registrationSuccess";

    public final String LOGIN_URL = "/login";
    public final String REGISTRATION_URL = "/registration";
    public final String LOGOUT_URL = "/logout";
    public final String DASHBOARD_URL = "/dashboard";
    public final String USER_DASHBOARD_URL = "/user-dashboard";
    public final String ADMIN_DASHBOARD_URL = "/admin-dashboard";

    public final String REDIRECT_LOGIN_URL = "redirect:/login";
    public final String REDIRECT_REGISTRATION_URL = "redirect:/registration";

    public final String ROLE_USER = "USER";
    public final String ROLE_ADMIN = "ADMIN";
    public final String ROLE_PREFIX = "ROLE_";
}
