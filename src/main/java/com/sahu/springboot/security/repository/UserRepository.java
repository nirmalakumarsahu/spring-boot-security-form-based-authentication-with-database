package com.sahu.springboot.security.repository;

import com.sahu.springboot.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
