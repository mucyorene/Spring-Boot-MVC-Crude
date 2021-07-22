package com.javaguides.springMCV.controller;

import com.javaguides.springMCV.Services.EmployeeService;
import com.javaguides.springMCV.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private EmployeeService employeeServices;

    EmployeeController(EmployeeService employeeService){
        this.employeeServices = employeeService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){

        model.addAttribute("listEmployee",employeeServices.getAllEmployees());

        return "index";
    }

    @GetMapping("/registerEmployeeForm")
    public String registerEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeServices.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/editForm/{id}")
    public String editForm(@PathVariable(value = "id") long id, Model model){
        Employee employee = employeeServices.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "EditEmployeeForm";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){
        System.out.println("Rwanda");
        this.employeeServices.deleteEmployee(id);
        return "redirect:/";
    }
}
