package com.sahu.springboot.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.authorizeHttpRequests( authorize -> authorize
                       .requestMatchers("/", "/login", "/registration").permitAll()
                       .requestMatchers("/dashboard").hasAnyRole("USER", "ADMIN")
                       .anyRequest().authenticated()
               )
               .csrf(AbstractHttpConfigurer::disable)
               .formLogin(form -> form
                       .loginPage("/login")
                       .loginProcessingUrl("/login")
                       .failureUrl("/login?error")
                       .usernameParameter("username")
                       .passwordParameter("password")
                       .defaultSuccessUrl("/dashboard", true)
       )
               .logout(logout -> logout
                       .logoutUrl("/logout")
                       .invalidateHttpSession(true)
                       .deleteCookies("JSESSIONID")
                       .logoutSuccessUrl("/login?logout")
               )
               .sessionManagement(session -> session
                       .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                       .invalidSessionUrl("/login?invalid-session")
                       .maximumSessions(1)
                       .maxSessionsPreventsLogin(false)
                       .expiredUrl("/login?session-expire")
               )
               .exceptionHandling(exception -> exception
                       .authenticationEntryPoint(customAuthenticationEntryPoint)
               );
        return  httpSecurity.build();
    }

}
