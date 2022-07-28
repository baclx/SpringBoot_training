package com.example.springboot2.dto;

import com.example.springboot2.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ListUser {
    private List<User> data;
}
