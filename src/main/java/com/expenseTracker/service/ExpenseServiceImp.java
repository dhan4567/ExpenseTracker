package com.expenseTracker.service;

import com.expenseTracker.dto.ExpenseRequestDto;
import com.expenseTracker.dto.ExpenseResponseDto;

import java.util.List;

    public interface ExpenseServiceImp {

        ExpenseResponseDto createExpense(ExpenseRequestDto dto);

        List<ExpenseResponseDto> getAllExpenses();

        ExpenseResponseDto getExpenseById(int expenseId);

        ExpenseResponseDto updateExpenseById(int expenseId, ExpenseRequestDto dto);

        void deleteExpense(int expenseId);
    }

