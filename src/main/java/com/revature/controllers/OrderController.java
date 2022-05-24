package com.revature.controllers;

import com.revature.models.Order;
import com.revature.repositories.OrderRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") String id) {
        Optional<Order> optional = orderRepository.findById(id);

        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/date")
    public ResponseEntity<List<Order>> findByDate(@RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> startDate, @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> endDate) {
        if(startDate.isPresent() || endDate.isPresent()) {
            return ResponseEntity.ok(orderRepository.findByDateBetween(startDate.orElse(LocalDate.of(1900, 1, 1)), endDate.orElse(LocalDate.of(5000, 1, 1))));
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<List<Order>> findByStoreId(@PathVariable("id") int id) {
        return ResponseEntity.ok(orderRepository.findByStoreId(id));
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<List<Order>> findByTransactionId(@PathVariable("id") String id) {
        return ResponseEntity.ok(orderRepository.findByTransactionId(id));
    }

    @GetMapping("/quantity")
    public ResponseEntity<List<Order>> findByQuantity(@RequestParam("minimum") Optional<Integer> minimum, @RequestParam("maximum") Optional<Integer> maximum) {
        if(minimum.isPresent() || maximum.isPresent()) {
            return ResponseEntity.ok(orderRepository.findByQuantityBetween(minimum.orElse(0), maximum.orElse(Integer.MAX_VALUE)));
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Order>> findByProductId(@PathVariable("id") String id, @RequestParam("minimum") Optional<Integer> minimum, @RequestParam("maximum") Optional<Integer> maximum) {
        if(minimum.isPresent() || maximum.isPresent()) {
            return ResponseEntity.ok(orderRepository.findByProductIdAndQuantityBetween(id, minimum.orElse(0), maximum.orElse(Integer.MAX_VALUE)));
        }

        return ResponseEntity.ok(orderRepository.findByProductId(id));
    }
}
