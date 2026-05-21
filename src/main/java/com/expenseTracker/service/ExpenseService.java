package com.expenseTracker.service;

import com.expenseTracker.dto.ExpenseRequestDto;
import com.expenseTracker.dto.ExpenseResponseDto;
import com.expenseTracker.entity.Expense;
import com.expenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ExpenseService implements ExpenseServiceImp {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseResponseDto createExpense(ExpenseRequestDto dto) {
        Expense expense = new Expense();
        expense.setCategory(dto.getCategory());

        Expense savedExpense = expenseRepository.save(expense);
        return convertToResponseDto(savedExpense);
    }

    @Override
    public List<ExpenseResponseDto> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseResponseDto getExpenseById(int expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new NoSuchElementException("Expense not found with id: " + expenseId));
        return convertToResponseDto(expense);
    }

    @Override
    public ExpenseResponseDto updateExpenseById(int expenseId, ExpenseRequestDto dto) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new NoSuchElementException("Expense not found with id: " + expenseId));

        expense.setCategory(dto.getCategory());

        Expense updatedExpense = expenseRepository.save(expense);
        return convertToResponseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(int expenseId) {
        if (!expenseRepository.existsById(expenseId)) {
            throw new NoSuchElementException("Expense not found with id: " + expenseId);
        }
        expenseRepository.deleteById(expenseId);
    }

    private ExpenseResponseDto convertToResponseDto(Expense expense) {
        ExpenseResponseDto responseDto = new ExpenseResponseDto();
        responseDto.setExpenseId(expense.getExpenseId());
        responseDto.setCategory(expense.getCategory());
        return responseDto;
    }
}

