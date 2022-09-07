package com.example.springboot2.service;

import com.example.springboot2.model.User;

public interface UserService {
    Boolean existsByUsername(String username);

    void saveUser(User user);
}
