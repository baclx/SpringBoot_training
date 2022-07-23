package com.example.springboot2.repository;

import com.example.springboot2.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Clazz, Integer> {
}
