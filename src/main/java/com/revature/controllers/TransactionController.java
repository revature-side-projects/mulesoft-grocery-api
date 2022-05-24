package com.revature.controllers;

import com.revature.models.Transaction;
import com.revature.repositories.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(transactionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable("id") String id) {
        Optional<Transaction> optional = transactionRepository.findById(id);

        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Transaction>> findByCustomerId(@PathVariable("id") String id) {
        return ResponseEntity.ok(transactionRepository.findByCustomerId(id));
    }

    @GetMapping("/type")
    public ResponseEntity<List<Transaction>> findByPaymentType(@RequestParam(value = "type") Optional<String> paymentType) {
        return ResponseEntity.ok(transactionRepository.findByPaymentType(paymentType.orElse(null)));
    }

    @GetMapping("/success/{success}")
    public ResponseEntity<List<Transaction>> findBySuccess(@PathVariable("success") boolean success) {
        return ResponseEntity.ok(transactionRepository.findBySuccess(success));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Transaction>> findByOrderIds(@RequestParam(name = "order_ids", required = true) List<String> ids) {
        return ResponseEntity.ok(transactionRepository.findDistinctByOrdersIdIn(ids));
    }
}
