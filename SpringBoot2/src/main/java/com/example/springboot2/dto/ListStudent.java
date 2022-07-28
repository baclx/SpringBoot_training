package com.example.springboot2.dto;

import com.example.springboot2.model.Student;
import com.example.springboot2.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ListStudent {
    private List<Student> data;
}
