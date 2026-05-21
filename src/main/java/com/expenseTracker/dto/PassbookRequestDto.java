package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PassbookRequestDto {
    private String transactionStatus;
    private String payerName;
    private String payeeName;
    private String paymentMethod;
    private Long amount;
    private Date date;
    private Long familyId;

    // Constructor
    public PassbookRequestDto() {
    }

    public PassbookRequestDto(String transactionStatus, String payerName, String payeeName,
                              String paymentMethod, Long amount, Date date, Long familyId) {
        this.transactionStatus = transactionStatus;
        this.payerName = payerName;
        this.payeeName = payeeName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
        this.familyId = familyId;
    }
}

