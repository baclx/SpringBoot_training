package com.example.springboot2.service;

import com.example.springboot2.model.User;
import com.example.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
