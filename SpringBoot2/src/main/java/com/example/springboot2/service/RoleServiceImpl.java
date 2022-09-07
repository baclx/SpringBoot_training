package com.example.springboot2.service;

import com.example.springboot2.model.Role;
import com.example.springboot2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> listAll() {
        return roleRepository.findAll();
    }

    @Override
    public Object save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void deleteByID(Long id) {
        roleRepository.deleteById(id);
    }
}
