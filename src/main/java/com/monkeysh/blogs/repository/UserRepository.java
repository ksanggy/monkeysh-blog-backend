package com.monkeysh.blogs.repository;

import com.monkeysh.blogs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAll();

}
