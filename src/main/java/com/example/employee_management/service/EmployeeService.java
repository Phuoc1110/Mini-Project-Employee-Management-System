package com.example.employee_management.service;

import com.example.employee_management.dto.CreateEmployeeRequest;
import com.example.employee_management.exception.ResourceNotFoundException;
import com.example.employee_management.model.Department;
import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee createEmployee(CreateEmployeeRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", request.getDepartmentId()));

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }

    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) { 
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    public List<Employee> searchEmployees(String query) {
        return employeeRepository.findByNameContainingIgnoreCaseOrDepartment_NameContainingIgnoreCase(query, query);
    }
}