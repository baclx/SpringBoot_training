package com.example.springboot2.controller.view;

import com.example.springboot2.model.Marks;
import com.example.springboot2.model.Student;
import com.example.springboot2.model.Subject;
import com.example.springboot2.service.MarksService;
import com.example.springboot2.service.StudentService;
import com.example.springboot2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/marks")
public class MarksController {
    @Autowired
    MarksService marksService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @GetMapping("/")
    public String index(
            Model model
    ) {
        model.addAttribute("title", "Marks Student");

        return "marks/index";
    }

    @GetMapping("LT")
    public String showMarksByLT(
            Model model
    ) {
        List<Marks> marksLists = marksService.findAllByType("LT");

        model.addAttribute("title", "Điểm Lý Thuyết");
        model.addAttribute("marksLists", marksLists);

        return "marks/LT/index";
    }

    @GetMapping("TH")
    public String showMarksByTH(
            Model model
    ) {
        List<Marks> marksLists = marksService.findAllByType("TH");

        model.addAttribute("title", "Điểm Thực Hành");
        model.addAttribute("marksLists", marksLists);

        return "marks/TH/index";
    }

    @GetMapping("add")
    public String create(
            Model model
    ) {
        List<Student> studentLists = studentService.getAllStudent();

        String keyword = null;
        List<Subject> subjectLists = subjectService.getAllSubject(keyword);

        model.addAttribute("marks", new Marks());
        model.addAttribute("studentLists", studentLists);
        model.addAttribute("subjectLists", subjectLists);
        model.addAttribute("title", "Create Marks For Student");

        return "marks/create";
    }

    @PostMapping("store")
    public String store(
            Marks marks,
            RedirectAttributes ra
    ) {
        marksService.save(marks);

        ra.addFlashAttribute("msg", "Create Success");

        return "redirect:/admin/marks/";
    }

    @GetMapping("edit/{id}")
    public String edit(
            Model model,
            @PathVariable("id") Long id,
            RedirectAttributes ra
    ) {
        Optional<Marks> marks = marksService.findById(id);

        List<Student> studentLists = studentService.getAllStudent();

        String keyword = null;
        List<Subject> subjectLists = subjectService.getAllSubject(keyword);

        if (marks.isPresent()) {
            model.addAttribute("marks", marks);
            model.addAttribute("studentLists", studentLists);
            model.addAttribute("subjectLists", subjectLists);
            model.addAttribute("title", "Edit Marks");
            return "marks/edit";
        }

        ra.addFlashAttribute("err", "Marks Not Found");
        return "redirect:/admin/marks/";
    }

    @PostMapping("update")
    public String update(
            Marks marks,
            RedirectAttributes ra
    ) {
        marksService.save(marks);
        ra.addFlashAttribute("msg", "Update Success");

        return "redirect:/admin/marks/";
    }

    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") Long id
    ) {
        marksService.deleteById(id);

        return "redirect:/admin/marks/";
    }
}
