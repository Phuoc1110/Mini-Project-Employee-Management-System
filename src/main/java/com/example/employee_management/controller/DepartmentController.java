package com.example.employee_management.controller;

import com.example.employee_management.model.Department;
import com.example.employee_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // API để tạo Department
    // POST http://localhost:8080/departments
    // Body: { "name": "Sales" }
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        // Chúng ta có thể gọi repository trực tiếp ở đây
        // vì logic rất đơn giản (không cần service)
        Department saved = departmentRepository.save(department);
        return ResponseEntity.ok(saved);
    }
}