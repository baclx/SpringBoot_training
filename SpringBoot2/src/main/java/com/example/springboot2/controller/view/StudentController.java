package com.example.springboot2.controller.view;

import com.example.springboot2.model.Clazz;
import com.example.springboot2.model.Student;
import com.example.springboot2.service.ClassService;
import com.example.springboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/student")
public class StudentController {
    private static final String UPLOAD_DIR = "src/main/resources/static/image/";

    @Autowired
    StudentService studentService;

    @Autowired
    ClassService classService;

    @GetMapping("/")
    public String student(
            Model model
    ) {
        List<Student> studentLists = studentService.getAllStudent();

        model.addAttribute("studentLists", studentLists);
        model.addAttribute("title", "List Student");

        return "student/index";
    }

    @GetMapping("add")
    public String create(
            Model model
    ) {
        List<Clazz> classLists = classService.getAll();

        model.addAttribute("students", new Student());
        model.addAttribute("classLists", classLists);
        model.addAttribute("title", "Create Student");

        return "student/create";
    }

    @PostMapping("store")
    public String store(
            Student student,
            RedirectAttributes ra,
            @RequestParam(name = "_image") MultipartFile file

    ) throws IOException {

        if (file.isEmpty()) {
        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR);
            //String avatar = path.toString();
            student.setImage("/image/" + fileName);
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentService.save(student);

        ra.addFlashAttribute("msg", "Create Success");

        return "redirect:/admin/student/";
    }

    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model,
            RedirectAttributes ra
    ) {
        Optional<Student> student = studentService.getById(id);

        if (student.isPresent()) {
            List<Clazz> classLists = classService.getAll();

            model.addAttribute("student", student);
            model.addAttribute("classLists", classLists);
            model.addAttribute("title", "Edit Student");
            return "student/edit";
        }

        ra.addFlashAttribute("err", "Student Not Found");
        return "redirect:/admin/student/";
    }

    @PostMapping("update")
    public String update(
            Student student,
            RedirectAttributes ra,
            @RequestParam(name = "_image") MultipartFile file
    ) {
        if (file.isEmpty()) {

        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path path = Paths.get(UPLOAD_DIR);

            student.setImage("/image/" + fileName);

            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentService.save(student);

        ra.addFlashAttribute("msg", "Update Success");

        return "redirect:/admin/student/";
    }

    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            RedirectAttributes ra
    ) {
        studentService.delete(id);
        ra.addFlashAttribute("msg", "Delete Success");

        return "redirect:/admin/student/";
    }
}
