package com.expenseTracker.service;

import com.expenseTracker.dto.BankRequestDto;
import com.expenseTracker.dto.BankResponseDto;

import java.util.List;

public interface BankServiceImp {
    BankResponseDto createBank(BankRequestDto dto);
    List<BankResponseDto> getAllBanks();
    BankResponseDto getBankById(Long id);
    BankResponseDto updateBank(Long id, BankRequestDto dto);
    void deleteBank(Long id);
}
