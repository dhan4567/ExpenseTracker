package com.expenseTracker.repository;

import com.expenseTracker.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Optional<Bank> findByBankName(String bankName);

    // Case-insensitive lookup
    Optional<Bank> findByBankNameIgnoreCase(String bankName);

    // Check if a bank with given name exists
    boolean existsByBankName(String bankName);
}
