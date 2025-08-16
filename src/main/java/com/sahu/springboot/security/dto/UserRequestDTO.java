package com.sahu.springboot.security.dto;

public record UserRequestDTO(
        String userName,
        String email,
        String password
) {
}
