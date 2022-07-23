package com.example.springboot2.service;

import com.example.springboot2.model.Marks;

import java.util.List;

public interface MarksService {
    List<Marks> listAll();

    Marks save (Marks marks);
}
