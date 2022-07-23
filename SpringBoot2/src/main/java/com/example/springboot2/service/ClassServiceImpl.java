package com.example.springboot2.service;

import com.example.springboot2.model.Clazz;
import com.example.springboot2.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository classRepository;

    @Override
    public List<?> listAll() {
        return classRepository.findAll();
    }

    @Override
    public Object save(Clazz clazz) {
        return classRepository.save(clazz);
    }

    @Override
    public void delete(int id) {
        classRepository.deleteById(id);
    }
}
