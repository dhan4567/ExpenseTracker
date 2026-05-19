package com.expenseTracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity

public class PassBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  transactionId;

    @Column(length = 50,nullable = false)
    private String transactionStatus;

    @Column(length = 50,nullable = false)
    private String payerName;

    @Column(length = 50,nullable = false)
    private String payeeName;

    @Column(length = 50,nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="family_id",nullable = false)
    private Family family;
}

