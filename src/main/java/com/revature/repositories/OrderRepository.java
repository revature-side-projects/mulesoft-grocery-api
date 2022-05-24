package com.revature.repositories;

import com.revature.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByProductId(String productId);
    List<Order> findByDateBetween(LocalDate start, LocalDate end);
    List<Order> findByStoreId(int storeId);
    List<Order> findByTransactionId(String id);
    List<Order> findByQuantityBetween(int minimum, int maximum);
    List<Order> findByProductIdAndQuantityBetween(String productId, int minimum, int maximum);
}
