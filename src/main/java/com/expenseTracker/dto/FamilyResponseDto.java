package com.expenseTracker.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FamilyResponseDto {
    private Long family_id;
    private String familyName;
    private String description;
    private List<UserRequestDto> members;

    //Constructor
    public FamilyResponseDto() {
    }

    public FamilyResponseDto(Long family_id, String familyName, String description, List<UserRequestDto> members){
        this.family_id=family_id;
        this.familyName=familyName;
        this.description=description;
        this.members=members;
    }

}