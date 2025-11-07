package com.example.employee_management.controller;

import com.example.employee_management.dto.CreateEmployeeRequest; // Import DTO
import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
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

    /**
     * Lab 4: Cập nhật API POST /add
     * - Giờ đây nó nhận DTO thay vì các RequestParam riêng lẻ
     */
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeRequest request) {
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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) { // Đổi int sang Long
        Employee found = employeeService.findEmployeeById(id);
        if (found != null) {
            return ResponseEntity.ok(found);
        } else {
            // Trả về 404 Not Found nếu không tìm thấy
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Lab 4: API Tìm kiếm MỚI (Task của Lab)
     * - Endpoint: /employees/search
     * - Tham số: ?query=...
     */
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam String query) {
        List<Employee> results = employeeService.searchEmployees(query);
        return ResponseEntity.ok(results);
    }

    /*
    // XÓA BỎ API GET /create CŨ CỦA LAB 3
    @GetMapping("/create")
    public String createEmployee(...) { ... }
    */
}