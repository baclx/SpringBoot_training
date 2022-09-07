package com.example.springboot2.service;

import com.example.springboot2.model.Marks;

import java.util.List;
import java.util.Optional;

public interface MarksService {
    List<Marks> listAll();

    Marks save (Marks marks);

    Optional<Marks> findById(Long id);

    List<Marks> findAllByType(String type);

    void deleteById(Long id);
}
