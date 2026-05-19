package com.expenseTracker.service;

import com.expenseTracker.dto.FamilyRequestDto;
import com.expenseTracker.dto.FamilyResponseDto;
import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.dto.UserResponseDto;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface UserServiceImp {

    UserResponseDto createFamily(UserRequestDto dto);

    List<UserResponseDto> getAllFamilies();

    UserResponseDto getFamilyById(Long userId);

    UserResponseDto updateFamilyById(Long userId,UserRequestDto dto);

    void deleteFamily(Long userId);

}
