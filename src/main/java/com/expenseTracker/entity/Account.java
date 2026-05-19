package com.expenseTracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accId;

    @Column(nullable = false, unique = true)
    private Long accNo;

    @Column(nullable= false)
    private Long balance;

    @Column(length=50,nullable = false)
    private String accStatus;

    @ManyToOne
    @JoinColumn(name="userId",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="bankId",nullable = false)
    private Bank bank;


}
