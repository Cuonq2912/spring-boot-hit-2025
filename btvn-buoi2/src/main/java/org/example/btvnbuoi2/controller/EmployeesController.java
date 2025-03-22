package org.example.btvnbuoi2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.btvnbuoi2.entity.Employees;
import org.example.btvnbuoi2.service.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService){
        this.employeesService = employeesService;
    }

    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "redirect:select" ;
    }

    @GetMapping
    public String getEmployees(Model model){
        List<Employees> employees = employeesService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employees employees, RedirectAttributes redirectAttributes){
        employeesService.saveEmployee(employees);
        redirectAttributes.addFlashAttribute("message", "Add employee successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes){
        employeesService.deleteEmployee(id);
        redirectAttributes.addFlashAttribute("message", "Delete employee successfully!");
        return "redirect:/employees";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employees employees, RedirectAttributes redirectAttributes){
        Optional<Employees> existingEmployee = employeesService.getEmployeeById(id);
        if(existingEmployee.isPresent()){
            employees.setId(id);
            employeesService.saveEmployee(employees);
            redirectAttributes.addFlashAttribute("message", "Update employee successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Employee not found!");
        }
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public Employees getEmployee(@PathVariable Long id) {
        return employeesService.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id: " + id));
    }
}
