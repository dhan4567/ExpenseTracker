package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ExpenseResponseDto {
    private int expenseId;
    private String category;
    private List<ExpenseResponseDto> expenses;
}

