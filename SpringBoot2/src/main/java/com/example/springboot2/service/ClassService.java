package com.example.springboot2.service;

import com.example.springboot2.model.Clazz;

import java.util.List;

public interface ClassService {
    List<?> listAll();

    Object save (Clazz clazz);

    void delete (int id);
}
