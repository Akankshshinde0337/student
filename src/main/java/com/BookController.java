package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookList;
    }

    // GET a book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST add a new book
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // PUT update book details
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                return "Book updated successfully!";
            }
        }
        return "Book not found.";
    }

    // DELETE a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean removed = bookList.removeIf(book -> book.getId() == id);
        return removed ? "Book deleted successfully!" : "Book not found.";
    }

    // Book model class
    static class Book {
        private int id;
        private String title;
        private String author;

        // Getters and Setters
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
