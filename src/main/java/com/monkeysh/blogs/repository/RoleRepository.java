package com.monkeysh.blogs.repository;

import com.monkeysh.blogs.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
