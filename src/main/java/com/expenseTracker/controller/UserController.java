package com.expenseTracker.controller;


import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.dto.UserResponseDto;
import com.expenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestMapping UserRequestDto dto) {
        return userService.createFamily(dto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllFamilies();
    }

    @GetMapping
    public UserResponseDto getUserById( Long userId) {
        return userService.getFamilyById(userId);
    }

    @PutMapping
    public UserResponseDto updateUserById( Long userId, UserRequestDto dto) {
        return userService.updateFamilyById(userId, dto);
}

    @DeleteMapping
    public String deleteUser( Long userId) {
        userService.deleteFamily(userId);
        return "user deleted successfully";
    }
}
