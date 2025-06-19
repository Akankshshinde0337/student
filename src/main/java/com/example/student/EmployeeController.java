package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // GET: Get employee by ID
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable int id) {
        return "Employee with ID: " + id;
    }

    // POST: Create a new employee
    @PostMapping
    public String createEmployee(@RequestBody String employeeName) {
        return "Employee created: " + employeeName;
    }

    // PUT: Update employee by ID
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody String updatedName) {
        return "Updated employee ID " + id + " with name: " + updatedName;
    }

    // DELETE: Delete employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Deleted employee with ID: " + id;
    }
}
