package com.expenseTracker.controller;


import com.expenseTracker.dto.PassbookRequestDto;
import com.expenseTracker.dto.PassbookResponseDto;
import com.expenseTracker.service.PassbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passbooks")
public class PassbookController {


    @Autowired
    private PassbookService passbookService;

    @PostMapping
    public PassbookResponseDto createPassbook(@RequestBody PassbookRequestDto dto) {
        return passbookService.createPassbook(dto);
    }

    @GetMapping
    public List<PassbookResponseDto> getAllPassbooks() {
        return passbookService.getAllPassbooks();
    }

    @GetMapping("/{transactionId}")
    public PassbookResponseDto getPassbookById(@PathVariable Long transactionId) {
        return passbookService.getPassbookById(transactionId);
    }

    @PutMapping("/{transactionId}")
    public PassbookResponseDto updatePassbookById(@PathVariable Long transactionId,
                                                  @RequestBody PassbookRequestDto dto) {
        return passbookService.updatePassbookById(transactionId, dto);
    }

    @DeleteMapping("/{transactionId}")
    public String deletePassbook(@PathVariable Long transactionId) {
        passbookService.deletePassbook(transactionId);
        return "Passbook deleted successfully";
    }
}

