package com.example.employee_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.config.SimplePasswordEncoder;
import com.example.employee_management.model.Employee;

@Service
public class EmployeeService {
	private final UtilityService utilityService;
    private final SimplePasswordEncoder passwordEncoder;
    private final List<Employee> employees = new ArrayList<>();
    
    @Autowired
    public EmployeeService(UtilityService utilityService, SimplePasswordEncoder passwordEncoder) {
        this.utilityService = utilityService;
        this.passwordEncoder = passwordEncoder;
        
        //mock data
        createEmployee("John Doe", 1, "pass123");
        createEmployee("JaneSmith", 2, "pass456");
    }

    public Employee createEmployee(String name, int id, String password) {
        String empCode = utilityService.generateEmployeeCode(id);
        String formattedName = utilityService.formatName(name);
        String encodedPassword = passwordEncoder.encode(password); //Luu vap DB
        
        Employee newEmployee = new Employee(id, empCode, formattedName);
        employees.add(newEmployee);

        return newEmployee;
    }

    public List<Employee> listEmployees() {
        return employees;
    }
    
    public Employee findEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }
}