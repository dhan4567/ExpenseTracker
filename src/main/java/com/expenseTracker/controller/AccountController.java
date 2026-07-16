package com.expenseTracker.controller;

import com.expenseTracker.dto.AccountRequestDto;
import com.expenseTracker.dto.AccountResponseDto;
import com.expenseTracker.service.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImp accountService;

    // Create a new account
    @PostMapping
    public AccountResponseDto createAccount(@RequestBody AccountRequestDto dto) {
        return accountService.createAccount(dto);
    }

    // Get all accounts
    @GetMapping
    public List<AccountResponseDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Get account by id
    @GetMapping("/{id}")
    public AccountResponseDto getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // Get all accounts for a specific user
    @GetMapping("/user/{userId}")
    public List<AccountResponseDto> getAccountsByUserId(@PathVariable Long userId) {
        return accountService.getAccountsByUserId(userId);
    }

    // Get all accounts in a specific bank
    @GetMapping("/bank/{bankId}")
    public List<AccountResponseDto> getAccountsByBankId(@PathVariable Long bankId) {
        return accountService.getAccountsByBankId(bankId);
    }

    // Update account details
    @PutMapping("/{id}")
    public AccountResponseDto updateAccount(@PathVariable Long id, @RequestBody AccountRequestDto dto) {
        return accountService.updateAccount(id, dto);
    }

    // Delete account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "Account deleted successfully";
    }
}
