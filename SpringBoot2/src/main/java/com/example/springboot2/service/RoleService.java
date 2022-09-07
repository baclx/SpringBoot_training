package com.example.springboot2.service;

import com.example.springboot2.model.Clazz;
import com.example.springboot2.model.Role;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);

    List<Role> listAll();

    Object save (Role role);

    Optional<Role> findById(Long id);

    void deleteByID(Long id);
}
