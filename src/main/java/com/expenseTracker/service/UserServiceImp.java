package com.expenseTracker.service;

import com.expenseTracker.dto.FamilyRequestDto;
import com.expenseTracker.dto.FamilyResponseDto;
import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.dto.UserResponseDto;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface UserServiceImp {

    UserResponseDto createUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Long userId);

    UserResponseDto updateUserById(Long userId,UserRequestDto dto);

    void deleteUser(Long userId);

}
