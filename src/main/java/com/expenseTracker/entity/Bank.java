package com.expenseTracker.entity;

import jakarta.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    @Column(nullable=false)
    private String bankName;



}
