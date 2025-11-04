package com.example.employee_management.controller;

import com.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/create")
    public String createEmployee(
        @RequestParam String name,
        @RequestParam int id,
        @RequestParam String password
    ) {
        return employeeService.createEmployee(name, id, password);
    }
}
