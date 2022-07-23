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

    @OneToMany(mappedBy = "subjectByIdSubject")
    @JsonManagedReference
    private Collection<Marks> marksById;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Subject subject = (Subject) o;
//
//        if (sem != subject.sem) return false;
//        if (duration != subject.duration) return false;
//        if (id != null ? !id.equals(subject.id) : subject.id != null) return false;
//        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
//        if (description != null ? !description.equals(subject.description) : subject.description != null) return false;
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + duration;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + sem;
//        return result;
//    }

    public Collection<Marks> getMarksById() {
        return marksById;
    }

    public void setMarksById(Collection<Marks> marksById) {
        this.marksById = marksById;
    }
}
