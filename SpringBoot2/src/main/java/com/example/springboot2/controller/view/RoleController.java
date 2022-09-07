package com.example.springboot2.controller.view;

import com.example.springboot2.model.Role;
import com.example.springboot2.service.RoleService;
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
@RequestMapping("admin/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public String index(
            Model model
    ) {
        List<Role> roleLists = roleService.listAll();

        model.addAttribute("roleLists", roleLists);
        model.addAttribute("title", "List Role");

        return "role/index";
    }

    @GetMapping("add")
    public String create(
            Model model
    ) {
        model.addAttribute("role", new Role());
        model.addAttribute("title", "Create Role");

        return "role/create";
    }

    @PostMapping("store")
    public String store(
            Role role,
            RedirectAttributes ra
    ) {
        roleService.save(role);
        ra.addFlashAttribute("msg", "Create Success");

        return "redirect:/admin/role/";
    }


    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model,
            RedirectAttributes ra
    ) {
        Optional<Role> role = roleService.findById(id);

        if (role.isPresent()) {
            model.addAttribute("title", "Edit Role");
            model.addAttribute("role", role);

            return "role/edit";
        }

        ra.addFlashAttribute("err", "Role Not Found");
        return "redirect:/admin/role/";
    }

    @PostMapping("update")
    public String update(
            Role role,
            RedirectAttributes ra
    ) {
        roleService.save(role);
        ra.addFlashAttribute("msg", "Update Success");

        return "redirect:/admin/role/";
    }

    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            RedirectAttributes ra
    ) {
//        Optional<Role> role = roleService.findById(id);
//        if (role.isPresent()) {
//
//            return "redirect:/admin/role/";
//        }
        roleService.deleteByID(id);
        ra.addFlashAttribute("msg", "Delete Success");

//        ra.addFlashAttribute("err", "Role Not Found");
        return "redirect:/admin/role/";
    }
}
