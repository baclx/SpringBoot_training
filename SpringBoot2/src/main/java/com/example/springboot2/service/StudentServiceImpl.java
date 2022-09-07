package com.example.springboot2.service;

import com.example.springboot2.model.Student;
import com.example.springboot2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> getByCode (String ma) {
        return studentRepository.findByCode(ma);
    }

    @Override
    public Optional<Student> getByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student getByPhone (String phone) {
        return studentRepository.findByPhone(phone);
    }

    @Override
    public Student getByName (String name) {
        return studentRepository.findByName(name);
    }
}
