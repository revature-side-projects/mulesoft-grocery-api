package com.revature.controllers;

import com.revature.models.Product;
import com.revature.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> query(@RequestParam(name = "prefix", required = false) Optional<String> prefix) {
        return prefix.map(s -> ResponseEntity.ok(productRepository.findByNameStartingWith(s))).orElseGet(() -> ResponseEntity.ok(productRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String id) {
        Optional<Product> optional = productRepository.findById(id);

        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Product>> findByPrice(@RequestParam(name = "greater", defaultValue = "false") boolean greater, @PathVariable("price") double price) {
        if(!greater) {
            return ResponseEntity.ok(productRepository.findByPriceLessThanEqual(price));
        }

        return ResponseEntity.ok(productRepository.findByPriceGreaterThanEqual(price));
    }
}
