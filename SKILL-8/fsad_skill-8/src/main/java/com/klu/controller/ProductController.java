package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    // Add product (for testing)
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // Get all products
    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    // a. Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // b. Price filter
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam Double min,
                                       @RequestParam Double max) {
        return service.getByPriceRange(min, max);
    }

    // c. Sorted products
    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return service.getSortedProducts();
    }

    // d. Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable Double price) {
        return service.getExpensiveProducts(price);
    }
}
