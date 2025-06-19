package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    // GET: Get order by ID
    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id) {
        return "Order details for ID: " + id;
    }

    // POST: Create a new order
    @PostMapping
    public String createOrder(@RequestBody String orderDetails) {
        return "Order created with details: " + orderDetails;
    }

    // PUT: Update an existing order
    @PutMapping("/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody String updatedDetails) {
        return "Order ID " + id + " updated with: " + updatedDetails;
    }

    // DELETE: Cancel an order
    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable int id) {
        return "Order with ID " + id + " has been cancelled.";
    }
}
