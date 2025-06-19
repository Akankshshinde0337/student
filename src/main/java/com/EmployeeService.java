package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();

    // Add a new employee
    public String addEmployee(Employee employee) {
        employeeList.add(employee);
        return "Employee added successfully!";
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update employee
    public String updateEmployee(int id, Employee updated) {
        Optional<Employee> existing = employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();

        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setName(updated.getName());
            emp.setDepartment(updated.getDepartment());
            return "Employee updated successfully!";
        } else {
            return "Employee not found.";
        }
    }

    // Delete employee
    public String deleteEmployee(int id) {
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);
        return removed ? "Employee deleted successfully." : "Employee not found.";
    }
}
