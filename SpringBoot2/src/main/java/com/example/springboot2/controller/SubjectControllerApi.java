package com.example.springboot2.controller;

import com.example.springboot2.model.Subject;
import com.example.springboot2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/subjects")
public class SubjectControllerApi {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> listAll() {
        return subjectService.getAllSubject();
    }

    @PostMapping
    public Subject addSubject(
            @RequestBody Subject subject
    ) {
        return subjectService.save(subject);
    }

    @GetMapping("/{id}")
    public Optional<Subject> getSubjectByID(
            @PathVariable("id") Long id
    ) {
        return subjectService.getByID(id);
    }

    @PutMapping("/{id}")
    public Subject putSubjectByID(
            @PathVariable("id") Long id,
            @RequestBody Subject newSubject
    ) {
        return subjectService.getByID(id)
            .map(subject -> {
                subject.setName(newSubject.getName());
                subject.setDescription(newSubject.getDescription());
                subject.setSem(newSubject.getSem());
                subject.setDuration(newSubject.getDuration());

                return subjectService.save(subject);
            })
            .orElseGet(() -> {
               newSubject.setId(id);

               return subjectService.save(newSubject);
            });
    }

    @DeleteMapping("/{id}")
    public void deleteSubjectByID(
            @PathVariable("id") Long id
    ) {
        subjectService.deleteByID(id);
    }

    @RequestMapping("/name={name}")
    public Subject getSubjectByName(
            @PathVariable("name") String name
    ) {
        return subjectService.getByName(name);
    }

    @RequestMapping("/sem={sem}")
    public Subject getSubjectBySem(
            @PathVariable("sem") int sem
    ) {
        return subjectService.getBySem(sem);
    }


}
