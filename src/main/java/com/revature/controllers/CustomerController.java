package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> query(@RequestParam(name = "prefix", required = false) Optional<String> prefix) {
        return prefix.map(s -> ResponseEntity.ok(customerRepository.findByNameStartingWith(s))).orElseGet(() -> ResponseEntity.ok(customerRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") String id) {
        Optional<Customer> optional = customerRepository.findById(id);

        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
