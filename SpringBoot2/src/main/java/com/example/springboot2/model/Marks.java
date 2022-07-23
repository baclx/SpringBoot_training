package com.example.springboot2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Marks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

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

    @ManyToOne
    @JoinColumn(name = "id_sv", referencedColumnName = "id", nullable = false)
//    @JsonBackReference
    private Student studentByIdSv;

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false)
//    @JsonBackReference
    private Subject subjectByIdSubject;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Marks marks = (Marks) o;
//
//        if (id != marks.id) return false;
//        if (idSv != marks.idSv) return false;
//        if (idSubject != marks.idSubject) return false;
//        if (mark != marks.mark) return false;
//        if (note != null ? !note.equals(marks.note) : marks.note != null) return false;
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + idSv;
//        result = 31 * result + idSubject;
//        result = 31 * result + mark;
//        result = 31 * result + (note != null ? note.hashCode() : 0);
//        return result;
//    }

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
