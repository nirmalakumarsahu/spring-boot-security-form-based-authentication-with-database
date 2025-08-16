package com.sahu.springboot.security.service.impl;

import com.sahu.springboot.security.model.Role;
import com.sahu.springboot.security.model.User;
import com.sahu.springboot.security.repository.UserRepository;
import com.sahu.springboot.security.security.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepository.findByUserName(username).ifPresentOrElse(user -> {

            List<String> userRoles = user.getRoles().stream().map(Role::getName).toList();
            List<GrantedAuthority> authorities = userRoles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role))
                    .collect(Collectors.toList());


            return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities, user.getId(), user.getEmail(), userRoles);

        }, () -> {
            log.error("User not found with email: {}", username);
            throw new UsernameNotFoundException("User not found with email: " + username);
        });
    }

}
