package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequestDto {
    private String category;

    // Constructor
    public ExpenseRequestDto() {
    }

    public ExpenseRequestDto(String category) {
        this.category = category;
    }
}

