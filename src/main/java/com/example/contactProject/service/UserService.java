package com.example.contactProject.service;

import com.example.contactProject.controller.dto.CreateUser;
import com.example.contactProject.repository.UserRepository;
import com.example.contactProject.repository.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(CreateUser createUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User newUser = new User();
        newUser.setName(createUser.getName());
        newUser.setFirstname(createUser.getFirstname());
        // photo ?
        newUser.setEmail(createUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUser.getPassword()));

        this.userRepository.save(newUser);
    }
}
