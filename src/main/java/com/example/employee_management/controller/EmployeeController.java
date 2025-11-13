package com.example.employee_management.controller;

import com.example.employee_management.dto.CreateEmployeeRequest; // Import DTO
import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
        // Gọi hàm createEmployee mới trong service
        Employee createdEmployee = employeeService.createEmployee(request);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listEmployees() {
        List<Employee> allEmployees = employeeService.listEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee found = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(found);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam String query) {
        List<Employee> results = employeeService.searchEmployees(query);
        return ResponseEntity.ok(results);
    }
}