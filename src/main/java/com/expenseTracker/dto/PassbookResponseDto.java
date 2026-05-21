package com.expenseTracker.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PassbookResponseDto {
    private Long transactionId;
    private String transactionStatus;
    private String payerName;
    private String payeeName;
    private String paymentMethod;
    private Long amount;
    private Date date;
    private Long familyId;
    private List<PassbookResponseDto> passbooks;

    // Constructor
    public PassbookResponseDto() {
    }

    public PassbookResponseDto(Long transactionId, String transactionStatus, String payerName,
                               String payeeName, String paymentMethod, Long amount, Date date,
                               Long familyId) {
        this.transactionId = transactionId;
        this.transactionStatus = transactionStatus;
        this.payerName = payerName;
        this.payeeName = payeeName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
        this.familyId = familyId;
    }
}

