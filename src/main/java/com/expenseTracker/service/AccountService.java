package com.expenseTracker.service;

import com.expenseTracker.dto.AccountRequestDto;
import com.expenseTracker.dto.AccountResponseDto;
import com.expenseTracker.entity.Account;
import com.expenseTracker.entity.Bank;
import com.expenseTracker.entity.User;
import com.expenseTracker.repository.AccountRepository;
import com.expenseTracker.repository.BankRepository;
import com.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AccountService implements AccountServiceImp {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BankRepository bankRepository;

    @Override
    public AccountResponseDto createAccount(AccountRequestDto dto) {
        // Fetch user and bank entities
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + dto.getUserId()));

        Bank bank = bankRepository.findById(dto.getBankId())
                .orElseThrow(() -> new NoSuchElementException("Bank not found with id: " + dto.getBankId()));

        // Check if account number already exists
        if (accountRepository.existsByAccountNumber(dto.getAccountNumber())) {
            throw new IllegalArgumentException("Account number already exists: " + dto.getAccountNumber());
        }

        // Create and save account
        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setBalance(dto.getBalance());
        account.setUser(user);
        account.setBank(bank);

        Account saved = accountRepository.save(account);
        return toResponse(saved);
    }

    @Override
    public List<AccountResponseDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponseDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with id: " + id));
        return toResponse(account);
    }

    @Override
    public List<AccountResponseDto> getAccountsByUserId(Long userId) {
        // Verify user exists
        if (!userRepository.existsById(userId)) {
            throw new NoSuchElementException("User not found with id: " + userId);
        }
        return accountRepository.findByUser_UserId(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountResponseDto> getAccountsByBankId(Long bankId) {
        // Verify bank exists
        if (!bankRepository.existsById(bankId)) {
            throw new NoSuchElementException("Bank not found with id: " + bankId);
        }
        return accountRepository.findByBank_BankId(bankId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponseDto updateAccount(Long id, AccountRequestDto dto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with id: " + id));

        // Update only if data provided
        if (dto.getAccountType() != null) {
            account.setAccountType(dto.getAccountType());
        }
        if (dto.getBalance() != null) {
            account.setBalance(dto.getBalance());
        }

        Account updated = accountRepository.save(account);
        return toResponse(updated);
    }

    @Override
    public void deleteAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new NoSuchElementException("Account not found with id: " + id);
        }
        accountRepository.deleteById(id);
    }

    // Helper: convert entity to response DTO
    private AccountResponseDto toResponse(Account account) {
        AccountResponseDto dto = new AccountResponseDto();
        dto.setAccountId(account.getAccountId());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setAccountType(account.getAccountType());
        dto.setBalance(account.getBalance());
        dto.setUserName(account.getUser().getUserName());
        dto.setUserId(account.getUser().getUserId());
        dto.setBankName(account.getBank().getBankName());
        dto.setBankId(account.getBank().getBankId());
        return dto;
    }
}
