package com.sahu.springboot.security.repository;

import com.sahu.springboot.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
