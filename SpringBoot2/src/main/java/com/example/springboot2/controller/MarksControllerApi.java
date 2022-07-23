package com.example.springboot2.controller;

import com.example.springboot2.model.Marks;
import com.example.springboot2.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marks")
public class MarksControllerApi {
    @Autowired
    MarksService marksService;

    @GetMapping
    public List<Marks> listAll() {
        return marksService.listAll();
    }

    @PostMapping
    public Marks save(
            @RequestBody Marks marks
    ) {
        return marksService.save(marks);
    }
}
