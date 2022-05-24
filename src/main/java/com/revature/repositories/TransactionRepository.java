package com.revature.repositories;

import com.revature.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByCustomerId(String id);
    List<Transaction> findBySuccess(boolean success);
    List<Transaction> findByPaymentType(String paymentType);
    List<Transaction> findDistinctByOrdersIdIn(List<String> orderIds);
}
