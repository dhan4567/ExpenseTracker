package com.expenseTracker.service;

import com.expenseTracker.dto.PassbookRequestDto;
import com.expenseTracker.dto.PassbookResponseDto;
import com.expenseTracker.entity.Family;
import com.expenseTracker.entity.PassBook;
import com.expenseTracker.repository.PassbookRepository;
import com.expenseTracker.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

    @Service
    public class PassbookService implements PassbookServiceImp {

        @Autowired
        private PassbookRepository passbookRepository;

        @Autowired
        private FamilyRepository familyRepository;

        @Override
        public PassbookResponseDto createPassbook(PassbookRequestDto dto) {
            PassBook passbook = new PassBook();
            passbook.setTransactionStatus(dto.getTransactionStatus());
            passbook.setPayerName(dto.getPayerName());
            passbook.setPayeeName(dto.getPayeeName());
            passbook.setPaymentMethod(dto.getPaymentMethod());
            passbook.setAmount(dto.getAmount());
            passbook.setDate(dto.getDate());

            Family family = familyRepository.findById(dto.getFamilyId())
                    .orElseThrow(() -> new NoSuchElementException("Family not found with id: " + dto.getFamilyId()));
            passbook.setFamily(family);

            PassBook savedPassbook = passbookRepository.save(passbook);
            return convertToResponseDto(savedPassbook);
        }

        @Override
        public List<PassbookResponseDto> getAllPassbooks() {
            return passbookRepository.findAll()
                    .stream()
                    .map(this::convertToResponseDto)
                    .collect(Collectors.toList());
        }

        @Override
        public PassbookResponseDto getPassbookById(Long transactionId) {
            PassBook passbook = passbookRepository.findById(transactionId)
                    .orElseThrow(() -> new NoSuchElementException("Passbook not found with id: " + transactionId));
            return convertToResponseDto(passbook);
        }

        @Override
        public PassbookResponseDto updatePassbookById(Long transactionId, PassbookRequestDto dto) {
            PassBook passbook = passbookRepository.findById(transactionId)
                    .orElseThrow(() -> new NoSuchElementException("Passbook not found with id: " + transactionId));

            passbook.setTransactionStatus(dto.getTransactionStatus());
            passbook.setPayerName(dto.getPayerName());
            passbook.setPayeeName(dto.getPayeeName());
            passbook.setPaymentMethod(dto.getPaymentMethod());
            passbook.setAmount(dto.getAmount());
            passbook.setDate(dto.getDate());

            if (dto.getFamilyId() != null) {
                Family family = familyRepository.findById(dto.getFamilyId())
                        .orElseThrow(() -> new NoSuchElementException("Family not found with id: " + dto.getFamilyId()));
                passbook.setFamily(family);
            }

            PassBook updatedPassbook = passbookRepository.save(passbook);
            return convertToResponseDto(updatedPassbook);
        }

        @Override
        public void deletePassbook(Long transactionId) {
            if (!passbookRepository.existsById(transactionId)) {
                throw new NoSuchElementException("Passbook not found with id: " + transactionId);
            }
            passbookRepository.deleteById(transactionId);
        }

        private PassbookResponseDto convertToResponseDto(PassBook passbook) {
            PassbookResponseDto responseDto = new PassbookResponseDto();
            responseDto.setTransactionId(passbook.getTransactionId());
            responseDto.setTransactionStatus(passbook.getTransactionStatus());
            responseDto.setPayerName(passbook.getPayerName());
            responseDto.setPayeeName(passbook.getPayeeName());
            responseDto.setPaymentMethod(passbook.getPaymentMethod());
            responseDto.setAmount(passbook.getAmount());
            responseDto.setDate(passbook.getDate());
            responseDto.setFamilyId(passbook.getFamily().getFamily_id());
            return responseDto;
        }
    }

