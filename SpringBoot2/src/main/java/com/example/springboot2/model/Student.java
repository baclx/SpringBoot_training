package com.example.springboot2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(nullable = false, unique = true, name = "code")
    private String code;

    @Basic
    @Size(min = 2, message = "have at least 2 characters")
    @Column(nullable = false, length = 30, name = "name")
    private String name;

    @Basic
    @Column(nullable = false, length = 30, name = "address")
    private String address;

    @Basic
    @NotEmpty
    @Email
    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Basic
    @Column(nullable = false, unique = true, name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    @JsonManagedReference
    private Clazz clazzByClassId;

//    @Basic
//    @Column(name = "class_id")
//    private int classId;

    @OneToMany(mappedBy = "studentByIdSv")
    @JsonBackReference
    private Collection<Marks> marksById;


//    @Basic
//    @Column(name = "class_id")
//    private int classId;

    public Clazz getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(Clazz clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Student student = (Student) o;
//
//        if (id != student.id) return false;
//        if (classId != student.classId) return false;
//        if (code != null ? !code.equals(student.code) : student.code != null) return false;
//        if (name != null ? !name.equals(student.name) : student.name != null) return false;
//        if (address != null ? !address.equals(student.address) : student.address != null) return false;
//        if (email != null ? !email.equals(student.email) : student.email != null) return false;
//        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (address != null ? address.hashCode() : 0);
//        result = 31 * result + (code != null ? code.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (phone != null ? phone.hashCode() : 0);
//        result = 31 * result + classId;
//        return result;
//    }

    public Collection<Marks> getMarksById() {
        return marksById;
    }

    public void setMarksById(Collection<Marks> marksById) {
        this.marksById = marksById;
    }
}
