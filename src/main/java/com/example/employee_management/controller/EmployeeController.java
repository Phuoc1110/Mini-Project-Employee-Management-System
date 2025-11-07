package com.example.employee_management.controller;

import com.example.employee_management.dto.CreateEmployeeRequest;
import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("/create")
//    public String createEmployee(
//        @RequestParam String name,
//        @RequestParam int id,
//        @RequestParam String password
//    ) {
//        return employeeService.createEmployee(name, id, password);
//    }
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeRequest request) {
        Employee createdEmployee = employeeService.createEmployee(
            request.getName(),
            request.getId(),
            request.getPassword()
        );
        
        // Trả về HTTP Status 201 Created cùng với đối tượng nhân viên vừa tạo
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listEmployees() { 
        List<Employee> allEmployees = employeeService.listEmployees();
        
        // Trả về HTTP Status 200 OK cùng với danh sách nhân viên
        return ResponseEntity.ok(allEmployees);
    }
    
    @GetMapping("/search")
    public String searchEmployeeByName(@RequestParam(required = false) String name) {
        if (name != null) {
            return "Đang tìm kiếm nhân viên với tên: " + name;
        }
        return "Vui lòng cung cấp tham số 'name'";
    }
}
