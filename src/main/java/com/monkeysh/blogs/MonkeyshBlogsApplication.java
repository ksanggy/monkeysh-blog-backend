package com.monkeysh.blogs;

import com.monkeysh.blogs.model.Role;
import com.monkeysh.blogs.model.User;
import com.monkeysh.blogs.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class MonkeyshBlogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonkeyshBlogsApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {

            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null,"상호", "김", "ksangho@hconnect.co.kr", "1234", new Date(), null, "소개글입니다.", "profile", new ArrayList<>()));

            userService.addRoleToUser("ksangho@hconnect.co.kr", "ROLE_ADMIN");
            userService.addRoleToUser("ksangho@hconnect.co.kr", "ROLE_USER");
        };
    }

}
