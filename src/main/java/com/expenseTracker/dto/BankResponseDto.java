package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankResponseDto {
    private Long bankId;
    private String bankName;

    public BankResponseDto() {}

    public BankResponseDto(Long bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }
}
