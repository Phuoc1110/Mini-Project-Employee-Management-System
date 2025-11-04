package com.example.employee_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.config.SimplePasswordEncoder;

@Service
public class EmployeeService {
	private final UtilityService utilityService;
    private final SimplePasswordEncoder passwordEncoder;
    
    @Autowired
    public EmployeeService(UtilityService utilityService, SimplePasswordEncoder passwordEncoder) {
        this.utilityService = utilityService;
        this.passwordEncoder = passwordEncoder;
    }

    public String createEmployee(String name, int id, String password) {
        String empCode = utilityService.generateEmployeeCode(id);
        String formattedName = utilityService.formatName(name);
        String encodedPassword = passwordEncoder.encode(password);

        return "Employee: " + empCode + " - " + formattedName + " - EncodedPass: " + encodedPassword;
    }
}