package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankRequestDto {
    private String bankName;

    public BankRequestDto() {}

    public BankRequestDto(String bankName) {
        this.bankName = bankName;
    }
}
