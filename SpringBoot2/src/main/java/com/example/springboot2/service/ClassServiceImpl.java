package com.example.springboot2.service;

import com.example.springboot2.model.Clazz;
import com.example.springboot2.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository classRepository;

    @Override
    public Page<Clazz> listAll(int pageNumber, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);

        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, 3, sort);
        return classRepository.findAll(pageable);
    }

    @Override
    public List<Clazz> getAll() {
        return (List<Clazz>) classRepository.findAll();
    }

    @Override
    public List<Clazz> searchByKey(String keyword) {
        if (keyword != null) {
            return classRepository.findAll(keyword);
        }
        return (List<Clazz>) classRepository.findAll();
    }


    @Override
    public Object save(Clazz clazz) {
        return classRepository.save(clazz);
    }

    @Override
    public Optional<Clazz> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public void deleteByID(Long id) {
        classRepository.deleteById(id);
    }

}
