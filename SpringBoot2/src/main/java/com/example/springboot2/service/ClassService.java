package com.example.springboot2.service;

import com.example.springboot2.model.Clazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    Page<Clazz> listAll(int pageNumber, String sortField, String sortDir);

    List<Clazz> getAll();

    List<Clazz> searchByKey (String keyword);

    Object save (Clazz clazz);

    Optional<Clazz> findById(Long id);

    void deleteByID(Long id);
}
