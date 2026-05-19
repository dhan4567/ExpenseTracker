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

    @Column(nullable = false)
    private Number mobNo;

    @Column(nullable = false, length = 50)
    private String role;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    //Constructors
    public User(){}

    public User(String userName, String email, Number mobNo, String role, Family family) {
        this.userName = userName;
        this.email = email;
        this.mobNo = mobNo;
        this.role = role;
        this.family = family;
    }
}