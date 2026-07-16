package com.expenseTracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Family {
    // Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long family_id;

    @Column(nullable = false)
    private String familyName;

    @Column(length = 500)
    private String description;  // Optional: family description

    @ManyToOne
    @JoinColumn(name="userId",nullable = false)
    private User user;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> members;  // Family members


}
