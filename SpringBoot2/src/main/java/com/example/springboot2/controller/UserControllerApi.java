package com.example.springboot2.controller;

import com.example.springboot2.model.Student;
import com.example.springboot2.model.User;
import com.example.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserControllerApi {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @PostMapping("")
    public User saveUser(
            @RequestBody User user
    ) {
        return userRepository.save(user);
    }
}
