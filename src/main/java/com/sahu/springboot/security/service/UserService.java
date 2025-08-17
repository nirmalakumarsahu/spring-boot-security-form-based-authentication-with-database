package com.sahu.springboot.security.service;

public interface UserService {
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    
}
