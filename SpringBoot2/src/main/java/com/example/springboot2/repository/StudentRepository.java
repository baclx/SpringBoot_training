//package com.example.springboot2.repository;
//
//import com.example.springboot2.model.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface StudentRepository extends JpaRepository<Student, Integer> {
//    Optional<Student> findByEmail(String email);
//    Optional<Student> findByMa(String ma);
//    @Query("select u from Student u where u.name = :name") // :name(param)
//    Student findByName(@Param("name") String name);
//
//    Student findByPhone (String phone);
//}
