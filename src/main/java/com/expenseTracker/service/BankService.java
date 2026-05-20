package com.expenseTracker.service;

import com.expenseTracker.dto.BankRequestDto;
import com.expenseTracker.dto.BankResponseDto;
import com.expenseTracker.entity.Bank;
import com.expenseTracker.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BankService implements BankServiceImp {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public BankResponseDto createBank(BankRequestDto dto) {
        Bank bank = new Bank();
        bank.setBankName(dto.getBankName());
        Bank saved = bankRepository.save(bank);
        return toResponse(saved);
    }

    @Override
    public List<BankResponseDto> getAllBanks() {
        return bankRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BankResponseDto getBankById(Long id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Bank not found with id: " + id));
        return toResponse(bank);
    }

    @Override
    public BankResponseDto updateBank(Long id, BankRequestDto dto) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Bank not found with id: " + id));
        bank.setBankName(dto.getBankName());
        Bank updated = bankRepository.save(bank);
        return toResponse(updated);
    }

    @Override
    public void deleteBank(Long id) {
        if (!bankRepository.existsById(id)) {
            throw new NoSuchElementException("Bank not found with id: " + id);
        }
        bankRepository.deleteById(id);
    }

    // helper: entity -> response DTO
    private BankResponseDto toResponse(Bank bank) {
        BankResponseDto dto = new BankResponseDto();
        dto.setBankId(bank.getBankId());
        dto.setBankName(bank.getBankName());
        return dto;
    }
}


