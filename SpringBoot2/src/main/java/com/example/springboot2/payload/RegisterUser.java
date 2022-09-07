package com.example.springboot2.payload;

import lombok.Data;

@Data
public class RegisterUser {
    private String username;
    private String password;
}
