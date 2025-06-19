package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    // GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST add a new employee
    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return "Employee added successfully!";
    }

    // PUT update employee
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee updated) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(updated.getName());
                emp.setDepartment(updated.getDepartment());
                return "Employee updated successfully!";
            }
        }
        return "Employee not found.";
    }

    // DELETE employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean removed = employeeList.removeIf(e -> e.getId() == id);
        return removed ? "Employee deleted." : "Employee not found.";
    }

    // Employee model
    static class Employee {
        private int id;
        private String name;
        private String department;

        // Getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
    }
}
