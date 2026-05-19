package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyRequestDto {

    private String familyName;
    private String description;

    public FamilyRequestDto(){}

    public FamilyRequestDto(String fam_Name,String description){
        this.familyName=fam_Name;
        this.description=description;
    }

}
