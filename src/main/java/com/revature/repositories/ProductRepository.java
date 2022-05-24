package com.revature.repositories;

import com.revature.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameStartingWith(String prefix);
    List<Product> findByPriceLessThanEqual(double maximum);
    List<Product> findByPriceGreaterThanEqual(double minimum);
}
