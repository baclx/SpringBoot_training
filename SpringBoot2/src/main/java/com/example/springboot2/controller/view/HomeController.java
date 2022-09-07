package com.example.springboot2.controller.view;

import com.example.springboot2.common.Const;
import com.example.springboot2.dto.ListStudent;
import com.example.springboot2.dto.ListUser;
import com.example.springboot2.model.Role;
import com.example.springboot2.model.Student;
import com.example.springboot2.model.User;
import com.example.springboot2.repository.UserRepository;
import com.example.springboot2.service.RoleService;
import com.example.springboot2.service.StudentService;
import com.example.springboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

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

    @GetMapping({"/", "/index"})
    public String index() {
        return "layout/index";
    }

    @GetMapping("/layout")
    public String layout() {
        return "layout";
    }

    @GetMapping("/content")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public String contentPage() {
        return "content";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(
//            RegisterUser registerUser
            User user
    ) {
        if (userService.existsByUsername(user.getUsername())) {

        } else {
//            User user = new User();
//            user.setUsername(registerUser.getUsername());
//
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            String encodedPass = encoder.encode(registerUser.getPassword());
//            user.setPassword(encodedPass);
//
//            Set<Role> roles = new HashSet<>();
//            Role role = roleService.findByName(Const.ROLE_USER).get();
//            roles.add(role);
//
//            user.setRoles(roles);
//

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPass = encoder.encode(user.getPassword());
            user.setPassword(encodedPass);

            Set<Role> roles = new HashSet<>();
            Role role = roleService.findByName(Const.ROLE_USER).get();
            roles.add(role);
            user.setRoles(roles);

            userService.saveUser(user);
        }

        return "redirect:/login";

    }
}
