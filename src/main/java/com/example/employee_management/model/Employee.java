package com.example.employee_management.model;

public class Employee {
	private int id;
	private String empCode;
	private String name;
	
	//Constructor
	public Employee(int id, String emCode, String name) {
		this.id = id;
		this.empCode = emCode;
		this.name = name;
	}
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
