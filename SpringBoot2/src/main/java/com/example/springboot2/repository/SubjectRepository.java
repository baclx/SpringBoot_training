package com.example.springboot2.repository;

import com.example.springboot2.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("select s from Subject s where s.name like %:name% ")
    List<Subject> findByName(String name);

    @Query("select s from Subject s where s.sem = :sem ")
    List<Subject> findAllBySem(int sem);

    @Query(value = "select count(Id) from Subject", nativeQuery = true)
    int countSubject();

    @Query(value = "select count(name) from Subject where sem = :sem", nativeQuery = true)
    int countSubjectBySem(int sem);

    @Query(value = "select * from Subject order by :name :sort", nativeQuery = true)
    List<Subject> findByAndSort(String name, String sort);

    List<Subject> findAllByOrderByIdDesc();

    List<Subject> findAllByOrderByNameDesc();
}
