package com.example.springboot2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Basic
//    @Column(name = "id_sv")
//    private int idSv;

//    @Basic
//    @Column(name = "id_subject")
//    private int idSubject;

    @Basic
    @Column(name = "mark")
    private int mark;

    @Basic
    @Column(name = "note")
    private String note;

    @Basic
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_sv", referencedColumnName = "id", nullable = false)
//    @JsonBackReference
    private Student studentByIdSv;

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false)
//    @JsonBackReference
    private Subject subjectByIdSubject;

    public Student getStudentByIdSv() {
        return studentByIdSv;
    }

    public void setStudentByIdSv(Student studentByIdSv) {
        this.studentByIdSv = studentByIdSv;
    }

    public Subject getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(Subject subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }
}
