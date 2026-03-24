package com.klu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> getByPriceRange(Double min, Double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> getSortedProducts() {
        return repo.getProductsSortedByPrice();
    }

    public List<Product> getExpensiveProducts(Double price) {
        return repo.getExpensiveProducts(price);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}
