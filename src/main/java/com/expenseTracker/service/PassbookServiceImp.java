package com.expenseTracker.service;


import com.expenseTracker.dto.PassbookRequestDto;
import com.expenseTracker.dto.PassbookResponseDto;

import java.util.List;

public interface PassbookServiceImp {

    PassbookResponseDto createPassbook(PassbookRequestDto dto);

    List<PassbookResponseDto> getAllPassbooks();

    PassbookResponseDto getPassbookById(Long transactionId);

    PassbookResponseDto updatePassbookById(Long transactionId, PassbookRequestDto dto);

    void deletePassbook(Long transactionId);
}

