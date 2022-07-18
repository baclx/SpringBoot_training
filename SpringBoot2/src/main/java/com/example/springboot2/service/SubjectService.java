package com.example.springboot2.service;

import com.example.springboot2.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubject();

    Subject save(Subject subject);

    Optional<Subject> getByID(Long id);

    void deleteByID(Long id);

    Subject getByName(String name);

    Subject getBySem(int sem);
}
