package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyRequestDto {

    private String familyName;
    private String description;
    private Long userId;
}
