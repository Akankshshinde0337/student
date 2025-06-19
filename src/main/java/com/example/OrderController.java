package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private List<Order> orderList = new ArrayList<>();

    // GET all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderList;
    }

    // GET order by ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderList.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST create order
    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        orderList.add(order);
        return "Order placed successfully!";
    }

    // PUT update order
    @PutMapping("/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody Order updated) {
        for (Order o : orderList) {
            if (o.getId() == id) {
                o.setProduct(updated.getProduct());
                o.setQuantity(updated.getQuantity());
                return "Order updated successfully!";
            }
        }
        return "Order not found.";
    }

    // DELETE order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        boolean removed = orderList.removeIf(o -> o.getId() == id);
        return removed ? "Order deleted." : "Order not found.";
    }

    // Order model
    static class Order {
        private int id;
        private String product;
        private int quantity;

        // Getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getProduct() { return product; }
        public void setProduct(String product) { this.product = product; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }
}
