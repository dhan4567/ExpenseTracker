package com.expenseTracker.entity;

import jakarta.persistence.*;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseId;

    @Column(nullable = false)
    private String category;


}
