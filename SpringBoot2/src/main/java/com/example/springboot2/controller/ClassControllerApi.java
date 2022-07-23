package com.example.springboot2.controller;

import com.example.springboot2.model.Clazz;
import com.example.springboot2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassControllerApi {
    @Autowired
    ClassService classService;

    @GetMapping
    public List<?> listAll() {
        return classService.listAll();
    }

    @PostMapping
    public Object createClass(
            @RequestBody Clazz clazz
    ) {
        return classService.save(clazz);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(
            @PathVariable("id") int id
    ) {
        classService.delete(id);
    }
}
