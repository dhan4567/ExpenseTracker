package com.expenseTracker.repository;

import com.expenseTracker.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByUser_UserId(Long userId);

    // Find all accounts in a specific bank
    List<Account> findByBank_BankId(Long bankId);

    // Find an account by account number
    Optional<Account> findByAccountNumber(String accountNumber);

    // Check if account number exists
    boolean existsByAccountNumber(String accountNumber);
}

