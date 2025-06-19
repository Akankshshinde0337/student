package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    // GET: Get product by ID
    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id) {
        return "Product with ID: " + id;
    }

    // POST: Add a new product
    @PostMapping
    public String addProduct(@RequestBody String productName) {
        return "Product added: " + productName;
    }

    // PUT: Update product by ID
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody String updatedName) {
        return "Product ID " + id + " updated to: " + updatedName;
    }

    // DELETE: Delete product by ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return "Product with ID " + id + " deleted";
    }
}
