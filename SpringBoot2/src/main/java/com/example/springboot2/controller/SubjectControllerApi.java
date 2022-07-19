package com.example.springboot2.controller;

import com.example.springboot2.model.Subject;
import com.example.springboot2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Subject> getSubjectByName(
            @PathVariable("name") String name
    ) {
        return subjectService.getByName(name);
    }

    @RequestMapping("/sem={sem}")
    public List<Subject> getSubjectBySem(
            @PathVariable("sem") int sem
    ) {
        return subjectService.getBySem(sem);
    }

//    @RequestMapping("/name={name}/sort={sort}")
//    public List<Subject> getNameAndSort(
//            @PathVariable("name") String name,
//            @PathVariable("sort") Sort sort
//    ) {
//        return subjectService.getNameAndSort(name, sort);
//    }

    @RequestMapping("/countSubject")
    public int countSubject() {
        return subjectService.countSubject();
    }

    @RequestMapping("/countSubject/sem={sem}")
    public int countSubjectBySem(
            @PathVariable("sem") int sem
    ) {
        return subjectService.countSubjectBySem(sem);
    }

    @RequestMapping("/find={name}")
    public List<Subject> findByAndSort(
            @PathVariable("name") String name,
            @RequestParam(defaultValue = "ASC") String sort
    ) {
        return subjectService.findByAndSort(name, sort);
    }

    @RequestMapping("/findIdAndSortDesc")
    public List<Subject> findIdAndSortDesc() {
        return subjectService.findByIdAndSortDesc();
    }

    @RequestMapping("findNameAndSortDesc")
    public List<Subject> findNameAndSortDesc() {
        return subjectService.findByNameSortDesc();
    }
}
