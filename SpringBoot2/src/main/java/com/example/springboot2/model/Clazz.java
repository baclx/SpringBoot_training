package com.example.springboot2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "class", schema = "aptech")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Basic
    @Column(name = "note")
    private String note;

    // use for api
//    @OneToMany
//    @JoinColumn(name = "class_id")
////    @JsonIgnore
//    private Collection<Student> studentsById;

//    public Collection<Student> getStudentsById() {
//        return studentsById;
//    }
//
//    public void setStudentsById(Collection<Student> studentsById) {
//        this.studentsById = studentsById;
//    }
}
