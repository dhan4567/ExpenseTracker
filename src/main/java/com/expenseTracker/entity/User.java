package com.expenseTracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false,length=10)
    private Long mobNo;

    @Column(nullable = false, length = 50)
    private String role;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;


}