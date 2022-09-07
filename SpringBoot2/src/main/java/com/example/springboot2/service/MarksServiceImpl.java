package com.example.springboot2.service;

import com.example.springboot2.model.Marks;
import com.example.springboot2.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarksServiceImpl implements MarksService{

    @Autowired
    MarksRepository marksRepository;

    @Override
    public List<Marks> listAll() {
        return marksRepository.findAll();
    }

    @Override
    public Marks save(Marks marks) {
        return marksRepository.save(marks);
    }

    @Override
    public Optional<Marks> findById(Long id) {
        return marksRepository.findById(id);
    }

    @Override
    public List<Marks> findAllByType(String type) {
        return marksRepository.findAllByType(type);
    }

    @Override
    public void deleteById(Long id) {
        marksRepository.deleteById(id);
    }
}
