package com.example.demo.controller;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeMvcController {

    private final EmployeeService service;

    public EmployeeMvcController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("employees", service.getAll());
        return "list-employees";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new EmployeeEntity());
        return "add-edit-employee";
    }

    @PostMapping
    public String createOrUpdate(@ModelAttribute("employee") EmployeeEntity employee) {
        service.createOrUpdate(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        EmployeeEntity e = service.getById(id).orElseThrow();
        model.addAttribute("employee", e);
        return "add-edit-employee";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }
}
