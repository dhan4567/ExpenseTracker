package com.expenseTracker.service;

import com.expenseTracker.dto.AccountRequestDto;
import com.expenseTracker.dto.AccountResponseDto;

import java.util.List;

public interface AccountServiceImp {
    // Create a new account for a user
    AccountResponseDto createAccount(AccountRequestDto dto);

    // Get all accounts
    List<AccountResponseDto> getAllAccounts();

    // Get account by id
    AccountResponseDto getAccountById(Long id);

    // Get all accounts for a specific user
    List<AccountResponseDto> getAccountsByUserId(Long userId);

    // Get all accounts in a specific bank
    List<AccountResponseDto> getAccountsByBankId(Long bankId);

    // Update account details
    AccountResponseDto updateAccount(Long id, AccountRequestDto dto);

    // Delete account
    void deleteAccount(Long id);
}





