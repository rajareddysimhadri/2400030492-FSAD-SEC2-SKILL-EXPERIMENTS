package com.klu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klu.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // 🔹 Derived Query Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(Double min, Double max);

    // 🔹 JPQL Queries

    // a. Sort by price (ascending)
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    // b. Products above price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensiveProducts(Double price);

    // c. Products by category (JPQL)
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getProductsByCategoryJPQL(String category);
}
