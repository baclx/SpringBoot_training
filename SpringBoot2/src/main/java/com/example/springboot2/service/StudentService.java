package com.example.springboot2.service;

import com.example.springboot2.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent ();

    Student save (Student student);

    void delete (Long id);

    Optional<Student> getById (Long id);

    Optional<Student> getByCode (String code);

    Optional<Student> getByEmail (String email);

    Student getByPhone (String phone);

    Student getByName (String name);
}
