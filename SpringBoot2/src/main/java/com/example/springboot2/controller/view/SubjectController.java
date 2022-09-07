package com.example.springboot2.controller.view;

import com.example.springboot2.model.Subject;
import com.example.springboot2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/")
    public String index(
            Model model,
            @Param("keyword") String keyword
    ) {
        List<Subject> subjectLists = subjectService.getAllSubject(keyword);

        model.addAttribute("keyword", keyword);
        model.addAttribute("subjectLists", subjectLists);
        model.addAttribute("title", "List Subject");

        return "subject/index";
    }

    @GetMapping("add")
    public String create(
            Model model
    ) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("title", "Add Subject");

        return "subject/create";
    }

    @PostMapping("store")
    public String store(
            Subject subject,
            RedirectAttributes ra
    ) {
        subjectService.save(subject);
        ra.addFlashAttribute("msg", "Create Success");

        return "redirect:/admin/subject/";
    }

    @GetMapping("edit/{id}")
    public String edit(
            Model model,
            @PathVariable("id") Long id,
            RedirectAttributes ra
    ) {
        Optional<Subject> subject = subjectService.getByID(id);

        if (subject.isPresent()) {
            model.addAttribute("subject", subject);
            model.addAttribute("title", "Edit Subject");
            return "subject/edit";
        }

        ra.addFlashAttribute("err", "Subject Not Found");
        return "redirect:/admin/subject";
    }

    @PostMapping("update")
    public String update(
            Subject subject,
            RedirectAttributes ra
    ) {

        subjectService.save(subject);
        ra.addFlashAttribute("msg", "Update Success");

        return "redirect:/admin/subject/";
    }

    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            RedirectAttributes ra
    ) {
        subjectService.deleteByID(id);
        ra.addFlashAttribute("msg", "Delete Success");

        return "redirect:/admin/subject/";
    }
}
