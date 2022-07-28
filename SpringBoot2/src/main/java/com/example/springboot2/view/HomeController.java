package com.example.springboot2.view;

import com.example.springboot2.dto.ListStudent;
import com.example.springboot2.dto.ListUser;
import com.example.springboot2.model.Student;
import com.example.springboot2.model.User;
import com.example.springboot2.repository.UserRepository;
import com.example.springboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("api/v1/listStudents")
    public ResponseEntity<ListStudent> listStudent() {
        List<Student> listStudents = studentService.getAllStudent();
        ListStudent ls = new ListStudent();

        ls.setData(listStudents);

        return new ResponseEntity<ListStudent>(ls, HttpStatus.OK);
    }

    @RequestMapping("api/v1/listUsers")
    public ResponseEntity<ListUser> listUser() {
        List<User> listUsers = userRepository.findAll();
        ListUser ls = new ListUser();

        ls.setData(listUsers);

        return new ResponseEntity<ListUser>(ls, HttpStatus.OK);
    }

    @GetMapping("/student/index")
    public String student() {
        return "student/index";
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/layout")
    public String layout() {
        return "layout";
    }

    @GetMapping("/content")
    public String contentPage() {
        return "content";
    }


}
