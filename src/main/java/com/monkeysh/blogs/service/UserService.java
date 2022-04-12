package com.monkeysh.blogs.service;

import com.monkeysh.blogs.model.Role;
import com.monkeysh.blogs.model.User;
import com.monkeysh.blogs.repository.RoleRepository;
import com.monkeysh.blogs.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository
            , PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            LOGGER.error("User not found.");
            throw new UsernameNotFoundException("User not found!");
        }
        else {
            LOGGER.info("User found with email : {}", email);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(), authorities);
    }

    public User findUserByEmail(User user){
        return userRepository.findByEmail(user.getEmail());
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

}
