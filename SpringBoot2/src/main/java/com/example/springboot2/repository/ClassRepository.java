package com.example.springboot2.repository;

import com.example.springboot2.model.Clazz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends PagingAndSortingRepository<Clazz, Long> {
    @Query("select c from Clazz c where c.name like %:keyword%")
    List<Clazz> findAll(String keyword);
}
