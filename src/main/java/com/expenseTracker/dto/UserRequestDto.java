package com.expenseTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String userName;
    private String email;
    private Number mobNo;
    private String role;

    //constructor
    public UserRequestDto() {
    }

    public UserRequestDto(String userName, String email, Number mobNo, String role) {
        this.userName = userName;
        this.email = email;
        this.mobNo = mobNo;
        this.role = role;
    }
}
