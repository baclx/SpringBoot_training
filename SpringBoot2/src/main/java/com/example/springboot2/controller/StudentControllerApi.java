//package com.example.springboot2.controller;
//
//import com.example.springboot2.model.Student;
//import com.example.springboot2.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/v1/students")
//public class StudentControllerApi {
//
//
//
//    @GetMapping
//    public List<Student> listAll() {
//        return studentService.getAllStudent();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Student> getStudent(
//            @PathVariable int id
//    ) {
//        return studentService.getById(id);
//    }
//
//    @GetMapping("/email={email}")
//    public Optional<Student> getStudentByEmail(
//        @PathVariable("email") String email
//    ) {
//        Optional<Student> student = studentService.getByEmail(email);
//
//        return student;
//    }
//
//    @GetMapping("/ma={ma}")
//    public Optional<Student> getStudentByMa(
//        @PathVariable("ma") String code
//    ) {
//        Optional<Student> student = studentService.getByCode(code);
//
//        return student;
//    }
//
//    @GetMapping("/name={name}")
//    public Student getStudentByName(
//        @PathVariable("name") String name
//    ) {
//        Student student = studentService.getByName(name);
//
//        return student;
//    }
//
//    @PostMapping
//    public Student saveStudent(
//            @RequestBody Student student
//    ) {
//        return studentService.save(student);
//    }
//
//    @PutMapping("/{id}")
//    public Student editStudent(
//            @PathVariable int id,
//            @RequestBody Student newStudent
//    ) {
//        return studentService.getById(id)
//            .map(student -> {
//                student.setMa(newStudent.getMa());
//                student.setAddress(newStudent.getAddress());
//                student.setEmail(newStudent.getEmail());
//                student.setName(newStudent.getName());
//                student.setSdt(newStudent.getSdt());
//
//                return studentService.save(student);
//            })
//            .orElseGet(() -> {
//                newStudent.setId(id);
//
//                return studentService.save(newStudent);
//            });
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStudent(
//            @PathVariable int id
//    ) {
//        studentService.delete(id);
//    }
//}
