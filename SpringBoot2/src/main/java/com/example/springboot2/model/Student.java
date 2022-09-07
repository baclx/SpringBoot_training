package com.example.springboot2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(nullable = false, unique = true, name = "code")
    private String code;

    @Basic
//    @Size(min = 2, message = "have at least 2 characters")
    @Column(nullable = false, length = 30, name = "name")
    private String name;

    @Basic
    @Column(nullable = false, length = 30, name = "address")
    private String address;

    @Basic
//    @NotEmpty
//    @Email
    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Basic
    @Column(nullable = false, unique = true, name = "phone")
    private String phone;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "class_id")
//    @JsonIgnore
    private Clazz clazzByClassId;

//    @Basic
//    @Column(name = "class_id")
//    private int classId;

//    @OneToMany(mappedBy = "studentByIdSv")
////    @JsonBackReference
//    private Collection<Marks> marksById;


//    @Basic
//    @Column(name = "class_id")
//    private int classId;

    public Clazz getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(Clazz clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }
}
