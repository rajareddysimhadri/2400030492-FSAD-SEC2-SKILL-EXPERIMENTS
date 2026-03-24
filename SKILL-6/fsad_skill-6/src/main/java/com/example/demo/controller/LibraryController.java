package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class LibraryController 
{

    @Autowired
    BookRepository repo;

    @GetMapping("/welcome")
    public String welcome()
    {
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public long getBookCount()
    {
        return repo.count();
    }

    @GetMapping("/price")
    public double getPrice()
    {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> getBooks()
    {
        return Arrays.asList("Java Programming", "Spring Boot Guide", "Data Structures", "Python Basics");
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id)
    {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title)
    {
        return "Searching for book titled : " + title;
    }

    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name)
    {
        return "Books written by Author : " + name;
    }

    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book)
    {
        return repo.save(book);
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks()
    {
        return repo.findAll();
    }

}