package com.expenseTracker.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountRequestDto {
    private String accountNumber;
    private String accountType;  // e.g., "Savings", "Current"
    private BigDecimal balance;
    private Long userId;         // Foreign key to User
    private Long bankId;         // Foreign key to Bank

    public AccountRequestDto() {}

    public AccountRequestDto(String accountNumber, String accountType, BigDecimal balance, Long userId, Long bankId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.userId = userId;
        this.bankId = bankId;
    }
}
