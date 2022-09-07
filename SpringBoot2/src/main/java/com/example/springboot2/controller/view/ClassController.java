package com.example.springboot2.controller.view;

import com.example.springboot2.model.Clazz;
import com.example.springboot2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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
@RequestMapping("admin/class")
public class ClassController {
    @Autowired
    ClassService classService;
    
    @GetMapping({"/page/1", "/"})
    public String index(
            Model model,
            @Param("sortField") String sortField,
            @Param("sortDir") String sortDir
    ) {
        return listPage(model, 1, sortField, sortDir);
    }

    @GetMapping("/page/{pageNumber}")
    public String listPage(
            Model model,
            @PathVariable("pageNumber") int currentPage,
            @Param("sortField") String sortField,
            @Param("sortDir") String sortDir
    ) {
        // sort
//        Sort sort = Sort.by("note").ascending();

        // pagination
        Page<Clazz> page = classService.listAll(currentPage, sortField, sortDir);
        
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();

        List<Clazz> clazzLists = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        // sort
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        // reverse sortDir
        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);

        model.addAttribute("clazzLists", clazzLists);
        model.addAttribute("title", "List Class");

        //search
//        String keyword = "T2108A1";
//        List<Clazz> search = classService.searchByKey(keyword);
//
//        model.addAttribute("search", search);

        return "class/index";
    }

    @GetMapping("/add")
    public String create(
            Model model
    ) {
        model.addAttribute("class", new Clazz());
        model.addAttribute("title", "Create Class");

        return "class/create";
    }

    @PostMapping("/store")
    public String store(
            Clazz clazz,
            RedirectAttributes ra
    ) {

        classService.save(clazz);
        ra.addFlashAttribute("msg", "Create Success");

        return "redirect:/admin/class/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model,
            RedirectAttributes ra
    ) {

        Optional<Clazz> clazz = classService.findById(id);

        if (clazz.isPresent()) {
            model.addAttribute("class", clazz);
            model.addAttribute("title", "Edit Class");
            return "class/edit";
        }

        ra.addFlashAttribute("err", "Class Not Found");
        return "redirect:/admin/class/";
    }

    @PostMapping("/update")
    public String update(
            Clazz clazz,
            RedirectAttributes ra
    ) {
        classService.save(clazz);
        ra.addFlashAttribute("msg", "Update Success");

        return "redirect:/admin/class/";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            RedirectAttributes ra
    ) {
        ra.addFlashAttribute("msg", "Delete Success");
        classService.deleteByID(id);

        return "redirect:/admin/class/";
    }
}
