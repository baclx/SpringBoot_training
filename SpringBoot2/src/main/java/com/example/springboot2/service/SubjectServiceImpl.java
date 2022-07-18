package com.example.springboot2.service;

import com.example.springboot2.model.Subject;
import com.example.springboot2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Optional<Subject> getByID(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public void deleteByID(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public List<Subject> getByName(String name) {
        return subjectRepository.findByName(name);
    }

    @Override
    public List<Subject> getBySem(int sem) {
        return subjectRepository.findAllBySem(sem);
    }

    @Override
    public int countSubject() {
        return subjectRepository.countSubject();
    }

    @Override
    public int countSubjectBySem(int sem) {
        return subjectRepository.countSubjectBySem(sem);
    }

//    @Override
//    public List<Subject> getNameAndSort(String name, Sort sort) {
//        return subjectRepository.findByNameAndSort(name, Sort.by("name"));
//    }



}
