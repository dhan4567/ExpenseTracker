package com.expenseTracker.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountResponseDto {
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private Long userId;
    private String userName;
    private Long bankId;
    private String bankName;

    public AccountResponseDto() {}

    public AccountResponseDto(Long accountId, String accountNumber, String accountType,
                              BigDecimal balance, Long userId, String userName, Long bankId, String bankName) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.userId = userId;
        this.userName = userName;
        this.bankId = bankId;
        this.bankName = bankName;
    }
}
