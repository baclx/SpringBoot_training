package com.example.springboot2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "sem")
    private int sem;

    @Basic
    @Column(name = "duration")
    private int duration;

//    @OneToMany(mappedBy = "subjectByIdSubject")
//    //@JsonManagedReference
//    private Collection<Marks> marksById;

}
