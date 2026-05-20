package com.expenseTracker.controller;


import com.expenseTracker.dto.BankRequestDto;
import com.expenseTracker.dto.BankResponseDto;
import com.expenseTracker.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {


    @Autowired
    private BankService bankService;

    // Create a bank
    @PostMapping
    public BankResponseDto createBank(@RequestBody BankRequestDto dto) {
        return bankService.createBank(dto);
    }

    // Get all banks
    @GetMapping
    public List<BankResponseDto> getAllBanks() {
        return bankService.getAllBanks();
    }

    // Get a bank by id
    @GetMapping("/{id}")
    public BankResponseDto getBankById(@PathVariable Long id) {
        return bankService.getBankById(id);
    }

    // Update a bank
    @PutMapping("/{id}")
    public BankResponseDto updateBank(@PathVariable Long id, @RequestBody BankRequestDto dto) {
        return bankService.updateBank(id, dto);
    }

    // Delete a bank
    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable Long id) {
        bankService.deleteBank(id);
        return "Bank deleted successfully";
    }
}

