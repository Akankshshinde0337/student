package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    // Simple GET endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    // GET with path variable
    @GetMapping("/hello/{name}")
    public String greetByName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // POST endpoint with request body
    @PostMapping("/greet")
    public String greetPerson(@RequestBody Person person) {
        return "Hello, " + person.getFirstName() + " " + person.getLastName() + "!";
    }

    // Simple model class for POST request
    static class Person {
        private String firstName;
        private String lastName;

        // Getters and Setters
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
