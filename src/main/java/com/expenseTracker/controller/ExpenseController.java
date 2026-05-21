package com.expenseTracker.controller;


import com.expenseTracker.dto.ExpenseRequestDto;
import com.expenseTracker.dto.ExpenseResponseDto;
import com.expenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ExpenseResponseDto createExpense(@RequestBody ExpenseRequestDto dto) {
        return expenseService.createExpense(dto);
    }

    @GetMapping
    public List<ExpenseResponseDto> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{expenseId}")
    public ExpenseResponseDto getExpenseById(@PathVariable int expenseId) {
        return expenseService.getExpenseById(expenseId);
    }

    @PutMapping("/{expenseId}")
    public ExpenseResponseDto updateExpenseById(@PathVariable int expenseId,
                                                @RequestBody ExpenseRequestDto dto) {
        return expenseService.updateExpenseById(expenseId, dto);
    }

    @DeleteMapping("/{expenseId}")
    public String deleteExpense(@PathVariable int expenseId) {
        expenseService.deleteExpense(expenseId);
        return "Expense deleted successfully";
    }
}

