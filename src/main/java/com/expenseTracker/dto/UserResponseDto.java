package com.expenseTracker.dto;


import com.expenseTracker.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDto {
    private Long userId;
    private String userName;
    private String email;
    private Number mobNo;
    private String role;
    private List<User> users;

    //constructor
    public UserResponseDto() {
    }

    public UserResponseDto(Long userId, String userName, String email, Number mobNo, String role,List<User> users) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.mobNo = mobNo;
        this.role = role;
        this.users=users;
    }
}


